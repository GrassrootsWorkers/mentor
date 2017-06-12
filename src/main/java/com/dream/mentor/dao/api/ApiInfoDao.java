package com.dream.mentor.dao.api;

import com.dream.mentor.bean.apiinfo.*;
import com.qdjk.apistore.bean.apiinfo.*;
import org.apache.ibatis.annotations.*;
import java.util.List;

/**
 * Created by Administrator on 2017/5/3.
 */
@Mapper
public interface ApiInfoDao {
    @InsertProvider(type = ApiSqlProvider.class, method = "insertUserSubscribeApiSQL")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int saveUserSubscribeApi(UserSubscribeApiInfo info);

    @Delete("delete from api_user_subscribe where id = #{id}")
    int deleteUserSubscribeApi(@Param("id") long id);

    @UpdateProvider(type = ApiSqlProvider.class, method = "updateUserSubscribeApiSQL")
    int updateUserSubscribeApi(UserSubscribeApiInfo info);

    @Select("select user_id as userId, api_id as apiId,api_provider_id as apiProviderId,used_times as usedTimes ,allow_times as allowTimes,peek_value as peekValue,expire_date as expireDate,create_date as createDate, update_date updateDate " +
            " from api_user_subscribe where user_id = #{userId}")
    List<UserSubscribeApiInfo> queryUserSubscribeApiInfoList(@Param("userId") long userId);

    @Select("select user_id as userId, api_id as apiId,api_provider_id as apiProviderId,used_times as usedTimes ,allow_times as allowTimes,peak_value as peakValue,expire_date as expireDate,create_date as createDate, update_date updateDate " +
           " from api_user_subscribe where user_id = #{userId} and api_id = #{apiId}")
    UserSubscribeApiInfo queryUserSubscribeApiInfo(@Param("userId") long userId,@Param("apiId") long apiId);


    @Select("select api_url as apiUrl,api_status as apiStatus from api_base_info where id =#{apiId}")
    ApiBaseInfo queryApiBaseInfoById(@Param("apiId") long apiId);

   @SelectProvider(type = ApiSqlProvider.class, method = "queryDetailApiBaseInfoSQL")
    ApiBaseInfo queryApiDetailInfoById(long apiId);

    @Select("select id,api_status as apiStatus from api_base_info where api_url = #{apiUrl}")
    ApiBaseInfo queryApiBaseInfoByUrl(@Param("apiUrl")String apiUrl);

    @SelectProvider(type = ApiSqlProvider.class, method = "queryApiInfoByCondition")
   /* @Select("select id,category_id as categoryId,api_name as apiName,icon,api_desc as apiDesc,api_url as apiUrl, api_status as apiStatus,data_type as dataType,invoke_method as invokeMethod,i_parameters as inputParameters ,o_parameters as outputParameters, invoke_Demo as invokeDemo,result_demo as resultDemo,update_date as updateDate,create_date as createDate" +
            " from api_base_info where  category_id = #{query.categoryId}")*/
    List<ApiBaseInfo> queryApiBaseInfoByCondition(ApiBaseInfo query);

    //>>>>>>>>>>>>>>>>api 分类信息
    //查询给定id的分类信息
    @Select("select id,father_id fatherId,name,icon from api_category where id = #{id}")
    ApiCategory queryApiCategoryById(@Param("id")long id);
    //查询一级分类下的所有二级分类
    @Select("select id,father_id fatherId,name,icon from api_category where farther_id = #{fatherId}")
    List<ApiCategory> queryApiCategoryByFatherId(@Param("fatherId")long fatherId);
    //查询所有分类
    @Select("select a.id,a.name,b.id as fatherId,b.name as fatherName  from api_category a join api_category b on a.father_id =b.id ")
    List<ApiCategory> queryAllApiCategory();

    //>>>>>>>>>>>>>>>>api 服务提供商信息
    @Select("select provider, provider_url as providerUrl,provider_desc providerDesc, api_key as apiKey" +
            " from  api_provider  where id = #{apiProviderId} and api_id =#{apiId} and status = 1")
    ApiProvider queryApiProvider(@Param("apiId") long apiId, @Param("apiProviderId") long apiProviderId);
    @Select("select provider, provider_url as providerUrl,provider_desc providerDesc, api_key as apiKey, update_date as updateDate" +
            " from  api_provider  where api_id =#{apiId} and status = 1")
    List<ApiProvider> queryApiProviderList(@Param("apiId")long apiId);
    //接口套餐相关
    @Select("select id,name,api_id as apiId,price,peak_value as peakValue,`desc`,charge_type as chargeType, create_date createDate,update_date updateDate " +
            " from api_pricing_package where api_id = #{apiId} order by price, charge_type")
    List<ApiPricingPackage> queryPricingPackageListByApiId(@Param("apiId")long apiId);

    @Select("select id,name,api_id as apiId,price,peak_value as peakValue,`desc`, charge_type as chargeType,create_date createDate,update_date updateDate " +
            " from api_pricing_package where id = #{id} ")
    ApiPricingPackage queryPricingPackageById(@Param("id") long id);

}
