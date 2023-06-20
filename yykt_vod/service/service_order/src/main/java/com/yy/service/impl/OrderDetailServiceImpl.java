package com.yy.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yy.mapper.OrderDetailMapper;
import com.yy.model.order.OrderDetail;
import com.yy.service.OrderDetailService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 订单明细 订单明细 服务实现类
 * </p>
 *
 * @author majinngor
 * @since 2023-06-12
 */
@Service
public class OrderDetailServiceImpl extends ServiceImpl<OrderDetailMapper, OrderDetail> implements OrderDetailService {

}
