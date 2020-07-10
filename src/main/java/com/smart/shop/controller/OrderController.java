package com.smart.shop.controller;

import com.smart.shop.domain.dto.OrderDto;
import com.smart.shop.domain.entity.Product;
import com.smart.shop.domain.entity.TbOrderItem;
import com.smart.shop.mapper.OrderItemMapper;
import com.smart.shop.mapper.OrderMapper;
import com.smart.shop.service.OrderService;
import com.smart.shop.utils.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 订单功能
 * 优惠券系统 积分系统 库存系统 物理系统 发票系统
 */
@RestController
@RequestMapping("/order")
public class OrderController {
    @Resource
    OrderService orderService;

    @Resource
    OrderItemMapper orderItemMapper;
    /**
     * 查询订单     查询
     * 生成订单     增加
     * 取消订单     更新
     */
    /**
     * 查询订单
     */


    /**
     * 取消订单
     */


    /**
     * 生成订单  如何生成订单号（要求在你的系统中必须是唯一）
     * 计算总价     优惠券 满减
     * 判断库存
     * 减少库存
     *      通过商品ID查询库存 --> update库存
     * 发起支付
     * 会员等级
     */
    @PostMapping("/add")
    public void order(OrderDto orderDto) {

    }

    @PostMapping("/save")
    public ResponseEntity<Integer> saveOrderDetails(TbOrderItem tbOrderItem) {
        try {
            int count = orderItemMapper.insertItem(tbOrderItem);
            return ResponseEntity.success(count);
        } catch (Exception e) {
            return ResponseEntity.error();
        }
    }


}
