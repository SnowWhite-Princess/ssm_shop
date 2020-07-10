package com.smart.shop.domain.entity;

import lombok.Data;

@Data
public class TbOrderItem {
    /**
     * 主键
     */
    private Integer orderItemId;

    /**
     * 订单号
     */
    private Integer orderId;

    /**
     * 会员Id
     */
    private Long memberId;

    /**
     * 商品图片
     */
    private String productPic;

    /**
     * 商品的名称
     */
    private String productName;

    /**
     * 商品的价格
     */
    private Long productPrice;

    /**
     * 购买的数量
     */
    private Integer productQuantity;

    /**
     * 状态
     */
    private Integer status;

    public Integer getOrderItemId() {
        return orderItemId;
    }

    public void setOrderItemId(Integer orderItemId) {
        this.orderItemId = orderItemId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public String getProductPic() {
        return productPic;
    }

    public void setProductPic(String productPic) {
        this.productPic = productPic;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Long getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Long productPrice) {
        this.productPrice = productPrice;
    }

    public Integer getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(Integer productQuantity) {
        this.productQuantity = productQuantity;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}