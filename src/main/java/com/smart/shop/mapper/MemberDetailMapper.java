package com.smart.shop.mapper;

import com.smart.shop.domain.entity.MemberDetail;

public interface MemberDetailMapper {
    int deleteByPrimaryKey(Integer memDetailId);

    int insert(MemberDetail record);

    int insertSelective(MemberDetail record);

    MemberDetail selectByPrimaryKey(Integer memDetailId);

    int updateByPrimaryKeySelective(MemberDetail record);

    int updateByPrimaryKey(MemberDetail record);
}