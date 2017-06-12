package com.dream.mentor.controller.trade;

import com.dream.mentor.bean.apiinfo.ApiBaseInfo;
import com.dream.mentor.bean.apiinfo.ApiPricingPackage;
import com.dream.mentor.bean.constant.ApiOrderStatusEnum;
import com.dream.mentor.cache.IRedisCache;
import com.dream.mentor.common.BaseAction;
import com.dream.mentor.interfaces.api.IApiInfoService;
import com.dream.mentor.interfaces.trade.IApiOrdersService;
import com.dream.mentor.bean.trade.ApiOrders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by Administrator on 2017/5/16.
 */
@Controller
@RequestMapping("/order")
public class ApiOrderController {
    @Autowired
    IApiInfoService apiInfoService;
    @Autowired
    IRedisCache redisCacheService;
    @Autowired
    IApiOrdersService ordersService;

    @RequestMapping(value = "/prepare", method = RequestMethod.POST)
    public Map<String, Object> prepareOrder(long apiId, long pricingPackageId, int count, HttpServletRequest request) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        String userName = BaseAction.getCookieValueByName(request, "un");
        long userId = redisCacheService.getLoginUserId(userName);
        if (userId <= 0) {
            resultMap.put("code", "login");
            resultMap.put("msg", "未登录，请登录");
            return resultMap;
        }
        ApiBaseInfo apiBaseInfo = apiInfoService.getApiDetailInfo(apiId);
        if (apiBaseInfo == null) {
            resultMap.put("code", "error");
            resultMap.put("msg", "接口不存在");
            return resultMap;
        }
        ApiPricingPackage pricingPackage = apiInfoService.getApiPricingPackageById(pricingPackageId);
        if (pricingPackage == null) {
            resultMap.put("code", "error");
            resultMap.put("msg", "系统异常");
            return resultMap;
        }
        ApiOrders orders = new ApiOrders();
        orders.setApiId(apiId);
        orders.setApiName(apiBaseInfo.getApiName());
        orders.setOrderNo(generateOrderNo(4));
        orders.setPricePackageCount(count);
        orders.setTotalPrice(pricingPackage.getPrice() * count);
        orders.setOrderStatus(ApiOrderStatusEnum.WAITING.getValue());
        orders.setPricePackageId(pricingPackageId);
        orders.setPricePackageName(pricingPackage.getName());
        orders.setPricePackagePrice(pricingPackage.getPrice());
        orders.setUserId(userId);
        orders.setCreateDate(new Date());
        orders.setUpdateDate(new Date());
        long orderId = ordersService.saveOrder(orders);
        if (orderId > 0) {
            redisCacheService.cacheCommitOrderId(orderId);
            //跳转支付页面
        }
        return null;
    }

    private String generateOrderNo(int randomLength) {
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
        String dataStr = format.format(new Date());
        Random random = new Random();
        for (int i = 0; i < 4; i++) {
            dataStr = dataStr + random.nextInt(9);
        }
        return dataStr;
    }
}
