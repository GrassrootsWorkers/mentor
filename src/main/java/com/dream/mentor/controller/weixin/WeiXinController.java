package com.dream.mentor.controller.weixin;

import com.dream.mentor.BaseAction;
import com.dream.mentor.bean.user.MentorUser;
import com.dream.mentor.bean.weixin.ReceivedMessage;
import com.dream.mentor.bean.weixin.SendMessage;
import com.dream.mentor.bean.weixin.WeixinDataConvert;
import com.dream.mentor.interfaces.user.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Date;

/**
 * Created by liuzhi on 2016/11/26.
 */
@Controller
@RequestMapping(value = "/mentor/wx")
public class WeiXinController extends BaseAction {
    private Logger logger = LoggerFactory.getLogger(WeiXinController.class);
    @Autowired
    IUserService userService;
    @RequestMapping(value = "/msg", method = RequestMethod.POST)
    public void getWeiXinMsgPost(HttpServletRequest request, HttpServletResponse response) {
        WeixinDataConvert<SendMessage> sendConvert = new WeixinDataConvert<SendMessage>();
        SendMessage sendMessage = new SendMessage();
        sendMessage.setCreateTime(new Date().getTime());
        sendMessage.setMsgType(SendMessage.MSG_TYPE_TXT);

        try {
            response.setCharacterEncoding("UTF-8");
            String xmlContent = getPostData(request);
            WeixinDataConvert<ReceivedMessage> convert = new WeixinDataConvert<ReceivedMessage>();
            ReceivedMessage receivedMsg = new ReceivedMessage();
            receivedMsg = convert.ConvertXmlToObject(xmlContent, receivedMsg);
            sendMessage.setFromUserName(receivedMsg.getToUserName());
            sendMessage.setToUserName(receivedMsg.getFromUserName());
            //关注返回 完善信息
            if ("event".equals(receivedMsg.getMsgType())) {
                logger.info("subscribe event>>>>>>>>>>>>>>openId={}", receivedMsg.getFromUserName());
                if ("subscribe".equals(receivedMsg.getEvent())) {
                    //返回完善资料的url
                    MentorUser user = new MentorUser();
                    user.setOpenId(receivedMsg.getFromUserName());
                    user.setPassword("123456");
                    userService.saveUser(user);
                    sendMessage.setContent(String.format("<a href='http://mentor.sangepg.com/mentor/user/to/bind?openId=%s&userId=%d'>完善用户信息</a>", receivedMsg.getFromUserName(),user.getId()));

                    String returnXml = sendConvert.ConvertObjectToXml(sendMessage);
                    logger.info("subscribe  return xml={}", returnXml);
                    response.getWriter().write(returnXml);
                    return;
                }else if("VIEW".equalsIgnoreCase(receivedMsg.getEvent())){
                    //验证手机号是否绑定
                }
            }

            String mobile = null;//
            //获取合作商的手机号
            if (mobile == null) {
                //sendMessage.setContent("账号未认证");
                //返回完善资料的url
                sendMessage.setContent(String.format("您还没完善您的联系方式 请点击<a href='http://m.sangepg.com/front/partner/toPage/partner?openId=%s'>《完善联系方式》</a>", receivedMsg.getFromUserName()));
                String returnXml = sendConvert.ConvertObjectToXml(sendMessage);
                logger.info("mobile return xml={}", returnXml);
                response.getWriter().write(returnXml);
                return;
            } else {
                sendMessage.setContent("相关功能在完善当中！");
                String returnXml = sendConvert.ConvertObjectToXml(sendMessage);
                response.getWriter().write(returnXml);
                logger.info("other return xml={}, openId={}", returnXml, receivedMsg.getFromUserName());
                return;
            }

        } catch (Exception e) {
            e.printStackTrace();
            logger.error("error msg={}", e.getMessage());
        }
    }

    private String getPostData(HttpServletRequest request) throws IOException {
        BufferedReader reader = request.getReader();
        String line;
        StringBuffer postData = new StringBuffer();
        while ((line = reader.readLine()) != null) {
            postData.append(line);
        }
        return postData.toString();
    }


}
