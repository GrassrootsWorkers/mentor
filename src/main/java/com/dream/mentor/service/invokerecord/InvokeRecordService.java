package com.dream.mentor.service.invokerecord;

import com.dream.mentor.bean.invokerecords.InvokeRecord;
import com.dream.mentor.dao.invokerecord.InvokeRecordDao;
import com.dream.mentor.interfaces.invokerecord.IInvokeRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/5/4.
 */
@Service
public class InvokeRecordService implements IInvokeRecordService {
    @Autowired
    private InvokeRecordDao invokeRecordDao;

    @Override
    public int insertInvokeRecord(InvokeRecord record) {
        return invokeRecordDao.insertInvokeRecord(record);
    }
}
