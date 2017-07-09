package com.dream.mentor.controller.user;

import com.dream.mentor.BaseAction;
import com.dream.mentor.bean.constant.UserTypeEnum;
import com.dream.mentor.bean.user.ExtraUserVo;
import com.dream.mentor.bean.user.MentorExtraUser;
import com.dream.mentor.bean.user.MentorUser;
import com.dream.mentor.cache.IRedisCache;
import com.dream.mentor.common.RandomStrUtil;
import com.dream.mentor.common.StringUtil;
import com.dream.mentor.configuration.MessageConfiguration;
import com.dream.mentor.service.user.UserServiceImpl;
import com.google.code.kaptcha.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
    @Autowired
    MessageConfiguration message;

    @RequestMapping(value = "/to/bind", method = RequestMethod.GET)
    public String toBindUserMobile(String openId, Integer userId, Model model, HttpServletResponse response) {
        MentorUser user = userService.getUserByOpenId(openId);
        if (StringUtil.areNotEmpty(user.getMobile())) {
            return "user/user_login";
        }
        super.response = response;
        super.addCookie("oid", openId, 365 * 24 * 60 * 60);
        user = new MentorUser();
        user.setUserId(userId);
        user.setOpenId(openId);
        model.addAttribute("user", user);
        return "user/bind_mobile";
    }

    @RequestMapping(value = "/bind", method = RequestMethod.POST)
    public String bindUserMobile(MentorUser user, Model model) {

        String msg = "";
        String captcha = redisCacheService.getCaptcha(user.getMobile());
        if (StringUtil.isEmpty(captcha) || !captcha.equals(user.getCaptcha())) {
            msg = message.getCaptchaMsg();
        } else {
            try {
                int count = userService.updateMentorUser(user);
                if (count >= 0) {
                    model.addAttribute("user", user);
                    return "user/bind_success";
                }
            } catch (Exception e) {
                e.printStackTrace();
                model.addAttribute("msg", message.getSystemErrorMsg());
            }
        }
        model.addAttribute("msg", msg);
        model.addAttribute("user", user);
        return "user/bind_mobile";
    }

    @RequestMapping(value = "captcha", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> sendCaptcha(String mobile) {
        String captcha = RandomStrUtil.getNumStr(6);
        //发送sms
        redisCacheService.setCaptcha(mobile, captcha);
        Map<String, Object> result = new HashMap<>();
        result.put("msg", "success");
        result.put("code", 200);
        return result;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String userLogin(HttpServletResponse response, HttpServletRequest request, String userName, String password, String captcha, Model model) {
        HttpSession session = request.getSession();
        String code = (String) session.getAttribute(Constants.KAPTCHA_SESSION_KEY);
        if(code == null || !code.equals(captcha)){
           model.addAttribute("msg","验证码错误");
            return "user/bind_mobile";
        }
        MentorUser mentorUser = userService.getUserByName(userName);
        if (mentorUser == null) {
            model.addAttribute("msg","用户不存在");
            return "user/bind_mobile";
        } else {
            String accessToken = userService.userLogin(mentorUser, password, "web");
            if (StringUtil.isEmpty(accessToken)) {
                model.addAttribute("msg","密码错误");
                return "user/bind_mobile";
            } else {
                Cookie userCookie = new Cookie("un", userName); //bake cookie
                userCookie.setPath("/");
                userCookie.setMaxAge(7 * 24 * 60 * 60); //set expire time to 1000 sec
                response.addCookie(userCookie); //put cookie in response
                Cookie accessTokenCookie = new Cookie("un", userName); //bake cookie
                accessTokenCookie.setPath("/");
                accessTokenCookie.setMaxAge(7 * 24 * 60 * 60); //set expire time to 1000 sec
                response.addCookie(accessTokenCookie); //put cookie in response
            }
        }
        if(UserTypeEnum.TEACHER.getValue().equals(mentorUser.getUserType())){
            return "student/list";
        }else{
            return "teacher/list";
        }

    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String registerUser(MentorUser mentorUser) {
        try {
            userService.saveUser(mentorUser);
            long userId = mentorUser.getUserId();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "mentorUser/user_login";
    }

    @RequestMapping(value = "/teacher/extra", method = RequestMethod.POST)
    public String saveExtraUserInfo(MentorExtraUser extraUser) {
        int id = userService.saveExtraUser(extraUser);
        return "teacher/project_experience";//上传项目经历
    }

    @RequestMapping(value = "/student/extra", method = RequestMethod.POST)
    public String saveStudentExtraUserInfo(ExtraUserVo extraUserVo) {
        MentorExtraUser extraUser = new MentorExtraUser();
        extraUser.setUserId(extraUserVo.getUserId());
        extraUser.setProvince(extraUserVo.getProvince());
        extraUser.setCity(extraUserVo.getCity());
        extraUser.setArea(extraUserVo.getArea());
        extraUser.setGraduateDate(extraUserVo.getGraduateDate());
        extraUser.setName(extraUserVo.getName());
        extraUser.setSchool(extraUserVo.getSchool());

        return "teacher/list";
    }
}
