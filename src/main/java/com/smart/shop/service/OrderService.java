package com.smart.shop.service;

import com.smart.shop.domain.dto.OrderDto;
import com.smart.shop.domain.entity.TbOrderItem;
import com.smart.shop.exception.ServiceException;

public interface OrderService {
    //生成订单
    String generateOrder(OrderDto orderDto) throws Exception, ServiceException;

    //保存订单详情
    int saveOrderDetails(TbOrderItem tbOrderItem);
}
