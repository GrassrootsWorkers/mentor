package com.dream.mentor.service.trade;

import com.dream.mentor.dao.trade.ApiOrderDao;
import com.dream.mentor.interfaces.trade.IApiOrdersService;
import com.dream.mentor.bean.trade.ApiOrders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/5/16.
 */
@Service
public class ApiOrdersServiceImpl implements IApiOrdersService {
    @Autowired
    ApiOrderDao apiOrderDao;
    @Override
    public long saveOrder(ApiOrders order){
        apiOrderDao.saveApiOrder(order);
        return order.getId();
    }
}
