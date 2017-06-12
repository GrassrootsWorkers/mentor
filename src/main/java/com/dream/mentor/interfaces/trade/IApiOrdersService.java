package com.dream.mentor.interfaces.trade;

import com.dream.mentor.bean.trade.ApiOrders;

/**
 * Created by Administrator on 2017/5/16.
 */
public interface IApiOrdersService {
    long saveOrder(ApiOrders order);
}
