package com.dream.mentor.controller.apiinfo;

import com.dream.mentor.bean.apiinfo.ApiCategory;
import com.dream.mentor.bean.apiinfo.ApiPricingPackage;
import com.dream.mentor.cache.IRedisCache;
import com.dream.mentor.interfaces.api.IApiInfoService;
import com.github.pagehelper.PageInfo;
import com.dream.mentor.bean.apiinfo.ApiBaseInfo;
import com.dream.mentor.bean.apiinfo.ApiProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import java.util.List;

/**
 * Created by Administrator on 2017/5/15.
 */
@Controller
@RequestMapping("/apiworks")
public class ApiInfoController {
    @Autowired
    IApiInfoService apiInfoService;
    @Autowired
    IRedisCache redisCacheService;
    @Autowired
    FreeMarkerConfigurer freeMarkerConfigurer;
    @RequestMapping("/servicelist")
    public String serviceList(String sortBy,int pageNo, Model model){
        ApiBaseInfo query = new ApiBaseInfo();
        query.setPageNo(pageNo);
        query.setPageNo(1);
        query.setPageSize(1);
        query.setCategoryId(2);
        PageInfo<ApiBaseInfo> pages = apiInfoService.getApiBaseInfoByCondition(query,sortBy);
        long pageCount = pages.getTotal();
        return "";

    }
    @RequestMapping(value = "/servicedetail/{apiId}.html", method = RequestMethod.GET)
    public String serviceDetail(@PathVariable("apiId") long apiId, Model model) {
        //获取接口信息
        ApiBaseInfo baseInfo = apiInfoService.getApiDetailInfo(apiId);
        if(baseInfo == null){
            return "error";
        }
        //获取接口提供商信息
        List<ApiProvider> apiProviderList = apiInfoService.getApiProviderList(apiId);
        //获取接口套餐信息
        List<ApiPricingPackage> pricingPackageList = apiInfoService.getApiPricingPackageList(apiId);
       /* try {
            Template template = freeMarkerConfigurer.getConfiguration().getTemplate("apistore/api_detail.ftl");
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        ApiCategory category = apiInfoService.getApiCategoryById(baseInfo.getCategoryId());
        ApiCategory fatherCategory = apiInfoService.getApiCategoryById(category.getFatherId());
        model.addAttribute("minPrice",pricingPackageList.get(0).getPrice());
        model.addAttribute("baseInfo", baseInfo);
        model.addAttribute("providers", apiProviderList);
        model.addAttribute("pricing", pricingPackageList);
        model.addAttribute("categoryName", category.getName());
        model.addAttribute("fatherName", fatherCategory.getName());
        return "apistore/api_detail";
    }
}
