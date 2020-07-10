package com.smart.shop.service.impl;

import com.smart.shop.domain.dto.CartsDto;
import com.smart.shop.domain.dto.OrderDto;
import com.smart.shop.domain.entity.Order;
import com.smart.shop.domain.entity.Product;
import com.smart.shop.domain.entity.TbOrderItem;
import com.smart.shop.exception.ServiceException;
import com.smart.shop.mapper.OrderItemMapper;
import com.smart.shop.mapper.OrderMapper;
import com.smart.shop.mapper.ProductMapper;
import com.smart.shop.service.OrderService;
import com.smart.shop.utils.ErrorStatus;
import com.smart.shop.utils.GenerateCodeUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Resource
    ProductMapper productMapper;

    @Resource
    OrderItemMapper orderItemMapper;

    @Resource
    OrderMapper orderMapper;

    /**
     * 1.生成订单号
     * 2.减少库存
     *
     * @param orderDto
     * @return
     */
    @Override
    @Transactional
    public String generateOrder(OrderDto orderDto) throws com.smart.shop.exception.ServiceException {
        String orderNo = GenerateCodeUtil.createCodeNum("OR");
        List<CartsDto> carts = orderDto.getCarts();
        //总价
        BigDecimal total = new BigDecimal(0);
        for (CartsDto cart : carts) {
            int pid = cart.getPid();
            Product product = productMapper.selectById(pid);
            //获取库存信息
            Integer stock = product.getStock();
            int num = cart.getCount();
            if (stock >= num) {
                //减少库存
                stock -= cart.getCount();
                //更新到数据库
                int i = productMapper.updateStockById(pid, stock, product.getVersion());
                if (i == 0) {
                    throw new com.smart.shop.exception.ServiceException(ErrorStatus.SERVICE_ERROR);
                }

                //update 表名 set stock = 1,version+=1 where pid=? and version = version


                //计算总价  价格 *  数量
                BigDecimal count = new BigDecimal(cart.getCount());
                BigDecimal price = product.getPromotePrice();
                //价格 * 数量
                BigDecimal multiply = price.multiply(count);
                //total
                total.add(multiply);
            } else {
                throw new ServiceException("库存不足",2000);
            }
        }
        //保存订单
        Order order = new Order();
        order.setOrderNo(orderNo);
        order.setTotal(total);
        order.setMemberId(orderDto.getMemberId());
        orderMapper.insert(order);

        //保存订单详情

        //发起支付
        return null;
    }

    @Override
    public int saveOrderDetails(TbOrderItem tbOrderItem) {
        int count = 0;

        //添加的操作
        tbOrderItem.setOrderId(tbOrderItem.getOrderId());
        tbOrderItem.setMemberId(tbOrderItem.getMemberId());
        tbOrderItem.setProductPic(tbOrderItem.getProductPic());
        tbOrderItem.setProductName(tbOrderItem.getProductName());
        tbOrderItem.setProductPrice(tbOrderItem.getProductPrice());
        tbOrderItem.setProductQuantity(tbOrderItem.getProductQuantity());
        count = orderItemMapper.insertItem(tbOrderItem);
        return count;
    }
}
