package com.smart.shop.domain.dto;

import lombok.Data;

/**
 * Dto作用：接收客户端传递的数据
 */
@Data
public class MemberDto {
    //查询的关键字 手机号 用户名 邮箱
    private String keyword;
    private Long memberId;
    private String username;
    private String phone;
    private String email;
    private String createDate;

    //关联详细信息
    private MemberDetailDto detailDto;


}
