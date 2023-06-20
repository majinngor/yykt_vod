package com.yy.controller;


import com.yy.ServiceOrderApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 订单明细 订单明细 前端控制器
 * </p>
 *
 * @author majinngor
 * @since 2023-06-12
 */
@RestController
@RequestMapping("/order-detail")
public class OrderDetailController {
    public static void main(String[] args) {
        SpringApplication.run(ServiceOrderApplication.class, args);
    }
}

