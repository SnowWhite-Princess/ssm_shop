package com.smart.shop.exception;

import com.smart.shop.utils.ErrorStatus;

/**
 * 20001 登录成功 xx
 * 40002 账号或密码错误
 * 40003 账号已被锁定 请与管理联系
 */
public class DaoException extends RuntimeException {
    //抛出异常的信息
    private String msg;
    //状态码
    private int status;

    public DaoException(String msg, int status) {
        this.msg = msg;
        this.status = status;
    }

    public DaoException(ErrorStatus status){
        this.msg = status.getMsg();
        this.status = status.getStatus();
    }
}
