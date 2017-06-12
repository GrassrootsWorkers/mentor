package com.dream.mentor.controller.user;

import com.dream.mentor.bean.user.User;
import com.dream.mentor.cache.IRedisCache;
import com.dream.mentor.common.StringUtil;
import com.dream.mentor.service.user.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/5/4.
 */
@Controller
@RequestMapping("/user")
public class UserController {
    Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    IRedisCache redisCacheService;
    @Autowired
    UserServiceImpl userService;
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public Map<String,String> userLogin(HttpServletResponse response,String userName, String password){
        Map<String,String> returnData = new HashMap<String,String>();
        User user = userService.getUserByName(userName);
        if(user == null){
            returnData.put("code","error");
            returnData.put("msg","用户不存在");
        }else{
            String accessToken = userService.userLogin(user,password,"web");
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
                    redisCacheService.userServerLogin(userName,user.getUserId());
                }catch (Exception e){
                    e.printStackTrace();
                }

            }
        }

        return returnData;
    }
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String registerUser(User user){
        try {
           userService.saveUser(user);
            long userId = user.getUserId();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "user/user_login";
    }
}
