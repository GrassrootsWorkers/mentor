package com.dream.mentor.controller.user;

import com.dream.mentor.BaseAction;
import com.dream.mentor.bean.user.MentorUser;
import com.dream.mentor.cache.IRedisCache;
import com.dream.mentor.common.RandomStrUtil;
import com.dream.mentor.common.StringUtil;
import com.dream.mentor.service.user.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/5/4.
 */
@Controller
@RequestMapping("/mentor/user")
public class UserController extends BaseAction {
    Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    IRedisCache redisCacheService;
    @Autowired
    UserServiceImpl userService;

    @RequestMapping(value = "/to/bind",method = RequestMethod.GET)
    public String toBindUserMobile(String openId, long userId, Model model, HttpServletResponse response){
        super.response = response;
        super.addCookie("oid",openId,365*24*60*60);
        model.addAttribute("openId",openId);
        model.addAttribute("userId",userId);
        return "user/bind_mobile";
    }
    @RequestMapping(value = "/bind",method = RequestMethod.POST)
    public String bindUserMobile(MentorUser user,Model model){
        String msg = "";
        String captcha = redisCacheService.getCaptcha(user.getMobile());
        if(StringUtil.isEmpty(captcha) || !captcha.equals(user.getCaptcha())){
            msg = "验证码错误";
        }else{
            try {
                int count = userService.updateMentorUser(user);
                if(count >0){
                    return "user/bind_success";
                }
            } catch (Exception e) {
                e.printStackTrace();
                model.addAttribute("msg","系统异常，请稍后再试");
            }
        }

        model.addAttribute("msg",msg);
        model.addAttribute("user",user);
        return "user/bind_mobile";
    }

    @RequestMapping(value = "captcha", method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> sendCaptcha(String mobile){
        String captcha = RandomStrUtil.getNumStr(6);
        //发送sms
        redisCacheService.setCaptcha(mobile,captcha);
        Map<String, Object> result = new HashMap<>();
        result.put("msg","success");
        result.put("code",200);
        return result;
    }
    @RequestMapping(value = "testSave", method = RequestMethod.GET)
    @ResponseBody
    public String testSave(String openId){
        MentorUser user = new MentorUser();
        user.setPassword("12312");
        user.setOpenId(openId);
        try {
            userService.saveUser(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user.getId()+"";
    }
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public Map<String,String> userLogin(HttpServletResponse response,String userName, String password){
        Map<String,String> returnData = new HashMap<String,String>();
        MentorUser mentorUser = userService.getUserByName(userName);
        if(mentorUser == null){
            returnData.put("code","error");
            returnData.put("msg","用户不存在");
        }else{
            String accessToken = userService.userLogin(mentorUser,password,"web");
            if(StringUtil.isEmpty(accessToken)){
                returnData.put("code","error");
                returnData.put("msg","密码错误");
            }else {
                returnData.put("code","success");
                returnData.put("msg","登录成功");
                returnData.put("accessToken",accessToken);
                Cookie foo = new Cookie("un", userName); //bake cookie
                foo.setPath("/");
                foo.setMaxAge(7*24*60*60); //set expire time to 1000 sec
                response.addCookie(foo); //put cookie in response
                try{
                    //redisCacheService.userServerLogin(userName, mentorUser.getUserId());
                }catch (Exception e){
                    e.printStackTrace();
                }

            }
        }

        return returnData;
    }
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String registerUser(MentorUser mentorUser){
        try {
           userService.saveUser(mentorUser);
            long userId = mentorUser.getUserId();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "mentorUser/user_login";
    }
}
