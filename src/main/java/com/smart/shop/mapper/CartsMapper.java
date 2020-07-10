package com.smart.shop.mapper;

import com.smart.shop.domain.entity.Carts;
import com.smart.shop.domain.entity.Order;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CartsMapper {
    List<Carts> selectAll(@Param("mid") int mid);

    Carts selectByMidAndPid(@Param("mid") int mid, @Param("pid") int pid);

    /**
     * 更新购物车的数据
     *
     * @param cartsId 购物车的ID
     * @param mid     数量
     * @return
     */
    int update(@Param("mid") int mid,@Param("cartsId") int cartsId);

    int insert(@Param("carts") Carts carts);

    int updateBatch(@Param("ids") List<Integer> ids);
}
