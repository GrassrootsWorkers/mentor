package com.dream.mentor.dao.trade;

import com.dream.mentor.bean.trade.ApiOrders;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.UpdateProvider;

/**
 * Created by Administrator on 2017/5/16.
 */
@Mapper
public interface ApiOrderDao {

    @InsertProvider(type = ApiOrderSqlProvider.class, method = "saveApiOrder")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int saveApiOrder(ApiOrders orders);

    @UpdateProvider(type = ApiOrderSqlProvider.class, method = "updateOrder")
    int updateApiOrder(ApiOrders orders);

}
