package com.dream.mentor.interfaces.api;

import com.dream.mentor.bean.apiinfo.*;
import com.github.pagehelper.PageInfo;
import com.qdjk.apistore.bean.apiinfo.*;

import java.util.List;

/**
 * Created by Administrator on 2017/5/12.
 */
public interface IApiInfoService {
    /**
     * 根据用户id查询用户订阅的api
     * @param userId
     * @return
     */
    List<UserSubscribeApiInfo> getUserSubscribeApiList(Long userId);

    /**
     * 获取用户订阅的api接口
     * @param userId
     * @param apiUrl
     * @return
     */
    UserSubscribeApiInfo getUserSubscribeApi(Long userId,String apiUrl);

    /**
     *
     * @param providerApiId 接口提供者的Id
     * @param apiId 接口的Id
     * @return
     */
    ApiProvider getApiProviderInfo(long apiId, long providerApiId);

    /**
     * 查看api接口详细信息
     * @param apiId
     * @return
     */
    ApiBaseInfo getApiDetailInfo(long apiId);

    /**
     * 根据条件查询接口信息
     * @param query
     * @return
     */
    PageInfo<ApiBaseInfo> getApiBaseInfoByCondition(ApiBaseInfo query, String orderBy);

    /**
     * 查看api接口的提供者的list
     * @param apiId
     * @return
     */
    List<ApiProvider> getApiProviderList(long apiId);

    /**
     * 查看接口的套餐
     * @param apiId
     * @return
     */
    List<ApiPricingPackage> getApiPricingPackageList(long apiId);

    /**
     * 查询单个套餐信息
     * @param pricingPackageId
     * @return
     */
    ApiPricingPackage getApiPricingPackageById(long pricingPackageId);

    /**
     * 根据分类id查询分类信息
     * @param id
     * @return
     */
    ApiCategory getApiCategoryById(long id);

    /**
     * 查询父分类下的子分类
     * @param fatherId
     * @return
     */
    List<ApiCategory> getApiCategoryByFatherId(long fatherId);

    /**
     * 查询所有api分类
     * @return
     */
    List<ApiCategory> getAllCategory();

}
