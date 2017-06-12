package com.dream.mentor.controller.apiinfo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Administrator on 2017/5/16.
 */
@Controller
@RequestMapping("apiworks")
public class ApiCategoryController {
    @RequestMapping(value = "categories", method = RequestMethod.GET)
    public String getApiCategoryList(){
    return null;
    }
}
