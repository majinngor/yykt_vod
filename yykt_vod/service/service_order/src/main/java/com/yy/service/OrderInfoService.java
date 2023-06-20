package com.yy.service;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yy.model.order.OrderInfo;
import com.yy.vo.order.OrderFormVo;
import com.yy.vo.order.OrderInfoQueryVo;
import com.yy.vo.order.OrderInfoVo;

import java.util.Map;

/**
 * <p>
 * 订单表 订单表 服务类
 * </p>
 *
 * @author majinngor
 * @since 2023-06-12
 */
public interface OrderInfoService extends IService<OrderInfo> {
    //订单列表
    Map<String,Object> findPageOrderInfo(Page<OrderInfo> pageParam, OrderInfoQueryVo orderInfoQueryVo);

    //生成点播课程订单
    Long submitOrder(OrderFormVo orderFormVo);

    OrderInfoVo getOrderInfoVoById(Long id);

    void updateOrderStatus(String out_trade_no);
}


