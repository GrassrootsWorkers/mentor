package com.dream.mentor.dao.invokerecord;

import com.dream.mentor.bean.invokerecords.InvokeRecord;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by Administrator on 2017/5/4.
 */
@Mapper
public interface InvokeRecordDao {
    @Insert("insert into api_invoke_history (user_id,parameters,parameters_hash_code,result_flag,ip,invoke_url,api_id,create_date)" +
            " values " +
            "(#{userId}, #{parameters},#{parametersHashCode},#{resultFlag},#{ip},#{invokeUrl},#{apiId},#{createDate})")
    int insertInvokeRecord(InvokeRecord record);
}
