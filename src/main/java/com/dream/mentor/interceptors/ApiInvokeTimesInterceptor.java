package com.dream.mentor.interceptors;

import com.dream.mentor.bean.invokerecords.InvokeRecord;
import com.dream.mentor.interfaces.api.IApiInfoService;
import com.google.common.util.concurrent.RateLimiter;
import com.dream.mentor.bean.apiinfo.UserSubscribeApiInfo;
import com.dream.mentor.bean.constant.UserStatusEnum;
import com.dream.mentor.bean.user.User;
import com.dream.mentor.cache.IRedisCache;
import com.dream.mentor.common.AesCiperTokenUtil;
import com.dream.mentor.common.BaseAction;
import com.dream.mentor.common.StringUtil;
import com.dream.mentor.interfaces.invokerecord.IInvokeRecordService;
import com.dream.mentor.interfaces.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.Map;
import java.util.Set;

/**
 * Created by Administrator on 2017/5/4.
 */
public class ApiInvokeTimesInterceptor implements HandlerInterceptor {
    @Autowired
    IInvokeRecordService invokeRecordService;
    @Autowired
    IUserService userService;
    @Autowired
    IRedisCache redisCacheService;

    @Autowired
    IApiInfoService userSubscribeApiInfoService;

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        String accessToken = httpServletRequest.getParameter("accessToken");
        //验证access_token是否过期
        String loginInfoStr = AesCiperTokenUtil.aesDecrypt(accessToken);
        if (StringUtil.isEmpty(loginInfoStr)) {
            return false;
        } else {
            String[] loginInfo = loginInfoStr.split(":");

            long time = Long.parseLong(loginInfo[1]);
            if (System.currentTimeMillis() - time >= 0) {
                throw new Exception("Token过期，请重新登录");
            } else {
                long userId = Long.parseLong(loginInfo[0]);
                //验证用户账户
                User user = userService.getUserById(userId);
                if (user == null) {
                    throw new Exception("用户已经被注销");
                } else {
                    //用户状态 定时任务更新用户状态
                    String userStatus = user.getUserStatus();
                    if (UserStatusEnum.ARREARS.getValue().equals(userStatus)) {
                        throw new Exception("已欠费，请充值后再重试");
                    } else {
                        UserSubscribeApiInfo userSubscribeApiInfo = userSubscribeApiInfoService.getUserSubscribeApi(userId, httpServletRequest.getRequestURI());
                        if (userSubscribeApiInfo == null) {
                            throw new Exception("没有订阅该接口");
                        }
                        if(userSubscribeApiInfo.getExpireDate()!=null && userSubscribeApiInfo.getExpireDate().before(new Date())){
                            throw new Exception("接口已过有效期，请充值后再试");
                        }
                        httpServletRequest.setAttribute("apiProviderId", userSubscribeApiInfo.getApiProviderId());
                        httpServletRequest.setAttribute("apiId", userSubscribeApiInfo.getApiId());
                        //先取调用次数后次数加1
                        int times = redisCacheService.getApiInvokeTime(userId, userSubscribeApiInfo.getApiId());

                        if (times >= userSubscribeApiInfo.getAllowTimes()) {
                            throw new Exception("您的余额不足，请充值后再调用");
                        }
                        //调用次数加1
                        redisCacheService.setApiInvokeTime(userId, userSubscribeApiInfo.getApiId());
                        if (UserStatusEnum.INSUFFICIENT.getValue().equals(userStatus)) {
                            //余额不足的用户限制一天调用的次数最大为该接口每天限制的最大次数
                            //限制速率 峰值的50%
                        } else {
                            RateLimiter rateLimiter = RateLimiter.create(2);
                            rateLimiter.acquire();
                            //查看峰值
                        }
                        saveSearchKeyword(httpServletRequest, userId,userSubscribeApiInfo.getApiId());
                        httpServletRequest.setAttribute("userId", userId);
                    }

                }


            }
        }
        return true;
    }

    private void saveSearchKeyword(HttpServletRequest request, long userId, long apiId) {
        InvokeRecord record = new InvokeRecord();
        Map<String, String[]> parameterMap = request.getParameterMap();
        Set<Map.Entry<String, String[]>> entrySet = parameterMap.entrySet();
        StringBuilder keyValueStr = new StringBuilder();
        for (Map.Entry<String, String[]> entry : entrySet) {
            String key = entry.getKey();
            if (!"accessToken".equals(key)) {
                String[] value = entry.getValue();
                keyValueStr.append(key).append("=").append(value[0]).append(";");
            }
        }
        record.setUserId(userId);
        record.setApiId(apiId);
        record.setParameters(keyValueStr.toString());
        record.setParametersHashCode(Math.abs(record.getParameters().hashCode()));
        record.setIp(StringUtil.ipToLong(BaseAction.getRemoteHost(request)));
        record.setInvokeUrl(request.getRequestURI());
        try {
            record.setCreateDate(new Date());
            invokeRecordService.insertInvokeRecord(record);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
