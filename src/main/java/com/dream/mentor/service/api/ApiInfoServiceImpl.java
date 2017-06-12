package com.dream.mentor.service.api;

import com.dream.mentor.bean.apiinfo.*;
import com.dream.mentor.dao.api.ApiInfoDao;
import com.dream.mentor.interfaces.api.IApiInfoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qdjk.apistore.bean.apiinfo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/5/3.
 */
@Service
public class ApiInfoServiceImpl implements IApiInfoService {
    @Autowired
    private ApiInfoDao apiInfoDao;

    @Override
    public List<UserSubscribeApiInfo> getUserSubscribeApiList(Long userId) {
        return apiInfoDao.queryUserSubscribeApiInfoList(userId);
    }

    @Override
    public UserSubscribeApiInfo getUserSubscribeApi(Long userId, String apiUrl) {
        ApiBaseInfo apiBaseInfo = apiInfoDao.queryApiBaseInfoByUrl(apiUrl);
        if (apiBaseInfo == null || apiBaseInfo.getApiStatus() == 0) {
            return null;
        } else {
            UserSubscribeApiInfo userSubscribeApiInfo = apiInfoDao.queryUserSubscribeApiInfo(userId, apiBaseInfo.getId());
            return userSubscribeApiInfo;
        }
    }

    @Override
    public ApiProvider getApiProviderInfo(long apiId, long providerApiId) {
        return apiInfoDao.queryApiProvider(apiId, providerApiId);
    }

    @Override
    public ApiBaseInfo getApiDetailInfo(long apiId) {
        return apiInfoDao.queryApiDetailInfoById(apiId);
    }

    @Override
    public PageInfo<ApiBaseInfo> getApiBaseInfoByCondition(ApiBaseInfo query, String orderBy) {
        PageHelper.startPage(query.getPageNo(), query.getPageSize(),orderBy);
        List<ApiBaseInfo> list = apiInfoDao.queryApiBaseInfoByCondition(query);
        PageInfo page = new PageInfo(list);
        return page;
    }

    @Override
    public List<ApiProvider> getApiProviderList(long apiId) {
        return apiInfoDao.queryApiProviderList(apiId);
    }

    @Override
    public List<ApiPricingPackage> getApiPricingPackageList(long apiId) {
        return apiInfoDao.queryPricingPackageListByApiId(apiId);
    }

    @Override
    public ApiPricingPackage getApiPricingPackageById(long apiId) {
        return apiInfoDao.queryPricingPackageById(apiId);
    }

    @Override
    public ApiCategory getApiCategoryById(long id) {
        return apiInfoDao.queryApiCategoryById(id);
    }

    @Override
    public List<ApiCategory> getApiCategoryByFatherId(long fatherId) {
        return apiInfoDao.queryApiCategoryByFatherId(fatherId);
    }

    @Override
    public List<ApiCategory> getAllCategory() {
        //PageHelper.offsetPage(1, 10);
        return apiInfoDao.queryAllApiCategory();
    }

}
