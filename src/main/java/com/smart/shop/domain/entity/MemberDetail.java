package com.smart.shop.domain.entity;

import java.util.Date;

public class MemberDetail {
    /**
     * 主键
     */
    private Integer memDetailId;

    /**
     * 1 表示男 2 表示女 3 保密
     */
    private Integer sex;

    /**
     * 地址
     */
    private String city;

    private Integer memberId;

    /**
     * 创建时间
     */
    private Date createDate;

    /**
     * 状态 1 表示正常 0 表示禁用
     */
    private Integer status;

    public Integer getMemDetailId() {
        return memDetailId;
    }

    public void setMemDetailId(Integer memDetailId) {
        this.memDetailId = memDetailId;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}