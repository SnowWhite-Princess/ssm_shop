package com.smart.shop.mapper;

import com.smart.shop.domain.entity.TbOrderItem;
import org.apache.ibatis.annotations.Param;

public interface OrderItemMapper {
    int insertItem(@Param("orderItem") TbOrderItem tbOrderItem);
}
