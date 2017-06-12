package com.dream.mentor.dao.trade;

import com.dream.mentor.bean.trade.ApiOrders;
import com.dream.mentor.common.StringUtil;
import org.apache.ibatis.jdbc.SQL;

/**
 * Created by Administrator on 2017/5/16.
 */
public class ApiOrderSqlProvider {
    public String saveApiOrder(final ApiOrders orders){
        return new SQL(){{
            INSERT_INTO("api_orders");
            VALUES("order_no","#{orderNo}");
            VALUES("trade_no","#{tradeNo}");
            VALUES("api_id","#{apiId}");
            VALUES("user_id","#{userId}");
            VALUES("api_name","#{apiName}");
            VALUES("price_package_id","#{pricePackageId}");
            VALUES("price_package_name","#{pricePackageName}");
            VALUES("price_package_price","#{pricePackagePrice}");
            VALUES("price_package_count","#{pricePackageCount}");
            VALUES("total_price","#{totalPrice}");
            VALUES("order_status","#{orderStatus}");
            VALUES("create_date","#{createDate}");
            VALUES("update_date","#{updateDate}");

        }
        }.toString();

    }
    //支付回调
    public String updateOrder(final ApiOrders orders){
       return new SQL(){{
           UPDATE("api_orders");
           SET("update_date = #{updateDate}");
           if (StringUtil.isNotEmpty(orders.getTradeNo())) {
               SET("trade_no = #{tradeNo}");
           }
           if(StringUtil.isNotEmpty(orders.getOrderStatus())){
               SET("order_status = #{orderStatus}");
           }
           WHERE("order_no = #{orderNo}");
       }}.toString();
    }
}
