package com.dream.mentor.controller;

import com.dream.mentor.bean.company.CompanyBaseInfo;
import com.dream.mentor.interfaces.company.ICompanyBaseInfoService;
import com.dream.mentor.service.api.ApiInfoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2017/5/3.
 */
@Controller
public class ElasticSearchController {
    @Autowired
    private ApiInfoServiceImpl userInfoService;
    @Autowired
    ICompanyBaseInfoService companyBaseInfoService;
    @RequestMapping("/test")
    public String helloElasticSearch(){
        CompanyBaseInfo baseInfo = new CompanyBaseInfo();
        baseInfo.setAddress("北京市昌平区回龙观龙腾苑六区");
        baseInfo.setCompanyName("北京启迪集团投资有限公司");
        baseInfo.setId(1L);
        baseInfo.setMinNumPeople(100);
        baseInfo.setMaxNunPeople(1000);
        companyBaseInfoService.save(baseInfo);
        CompanyBaseInfo info = companyBaseInfoService.queryCompanyBaseInfoByName("启迪集团");
        info = companyBaseInfoService.queryCompanyBaseInfoById(1L);

       return "redirect:/html/user/user_login.html";
    }
}
