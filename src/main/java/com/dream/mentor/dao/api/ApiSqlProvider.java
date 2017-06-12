package com.dream.mentor.dao.api;

import com.dream.mentor.bean.apiinfo.ApiBaseInfo;
import com.dream.mentor.bean.apiinfo.UserSubscribeApiInfo;
import org.apache.ibatis.jdbc.SQL;

/**
 * Created by Administrator on 2017/5/11.
 */
public class ApiSqlProvider {
    public String updateUserSubscribeApiSQL(final UserSubscribeApiInfo info) {
        return new SQL() {
            {
                UPDATE("api_user_subscribe");
                SET("update_date = #{updateDate}");
                if (info.getApiProviderId() > 0) {
                    SET("api_provider_id = #{apiProviderId}");
                }
                if(info.getUsedTimes() >0){
                    SET("used_times = #{usedTimes}");
                }
                if(info.getExpireDate() !=null){
                    SET("expire_date","#{expireDate}");
                }
                if(info.getId()>0){
                    WHERE("id = #{id}");
                }

                if (info.getUserId() > 0) {
                    WHERE("user_id = #{userId}");
                }

            }

        }.toString();
    }

    public String insertUserSubscribeApiSQL(final UserSubscribeApiInfo info) {
        return new SQL() {{
            INSERT_INTO("api_user_subscribe");
            VALUES("user_id", "#{userId}");
            VALUES("api_id", "#{apiId}");
            VALUES("api_provider_id", "#{apiProviderId}");
            VALUES("used_times", "#{usedTimes}");
            VALUES("allow_times", "#{allowTimes}");
            VALUES("peek_value", "#{peekValue}");
            VALUES("create_date", "#{createDate}");
            VALUES("update_date", "#{updateDate}");
        }}.toString();
    }
    public String queryDetailApiBaseInfoSQL(){
        return new SQL(){{
            SELECT("id,category_id as categoryId,api_name as apiName,icon,api_desc as apiDesc,api_url as apiUrl, api_status as apiStatus,data_type as dataType,invoke_method as invokeMethod,i_parameters as inputParameters ,o_parameters as outputParameters, invoke_Demo as invokeDemo,result_demo as resultDemo,update_date as updateDate,create_date as createDate");
            FROM("api_base_info");
            WHERE("id = #{apiId}");
        }}.toString();

    }
    public String queryApiInfoByCondition(final ApiBaseInfo query){
        return new SQL(){{
            SELECT("id,category_id as categoryId,api_name as apiName,icon,api_desc as apiDesc,api_url as apiUrl, api_status as apiStatus,data_type as dataType,invoke_method as invokeMethod,i_parameters as inputParameters ,o_parameters as outputParameters, invoke_Demo as invokeDemo,result_demo as resultDemo,update_date as updateDate,create_date as createDate");
            FROM("api_base_info");
            if(query.getCategoryId() >0){
                WHERE("category_id =#{categoryId}");
            }
        }}.toString();
    }
}
