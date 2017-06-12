package com.dream.mentor.interfaces.invokerecord;

import com.dream.mentor.bean.invokerecords.InvokeRecord;

/**
 * Created by Administrator on 2017/5/5.
 */
public interface IInvokeRecordService {
    /**
     * 用户查询一次就往数据库添加一条记录
     * @param record
     * @return
     */
    int insertInvokeRecord(InvokeRecord record);
}
