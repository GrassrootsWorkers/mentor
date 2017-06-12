package com.dream.mentor.controller.invokerecord;

import com.dream.mentor.bean.invokerecords.QuerySearchBean;
import com.dream.mentor.factory.apiprovider.IApiProviderFactory;
import com.dream.mentor.factory.apiprovider.QDJKSearchFactory;
import com.dream.mentor.interfaces.api.IApiInfoService;
import com.dream.mentor.bean.apiinfo.ApiProvider;
import com.dream.mentor.bean.constant.ApiProviderDirectory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by Administrator on 2017/5/4.
 */
@RestController
@RequestMapping("/api")
public class SearchInvokeRecordController {
    @Autowired
    IApiInfoService userSubscribeApiInfoService;
    private String charset ="UTF-8";
    @RequestMapping(value = "search", method = RequestMethod.GET)
    public String search(HttpServletRequest request,QuerySearchBean search) throws IOException {
        long apiProviderId = (Long)request.getAttribute("apiProviderId");
        long apiId = (Long)request.getAttribute("apiId");
        //获取服务提供者的url
        ApiProvider apiProvider = userSubscribeApiInfoService.getApiProviderInfo(apiId, apiProviderId);
        String result = null;
       String apiKey = apiProvider.getApiKey();
       if(ApiProviderDirectory.QDJK.getValue().equals(apiKey)){
           IApiProviderFactory qdjk = new QDJKSearchFactory();
           result = qdjk.createProviderFactory().doGet(apiProvider.getProviderUrl(),search,charset);
           return result;
       }

        return result;
    }

}
