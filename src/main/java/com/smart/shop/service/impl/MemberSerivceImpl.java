package com.smart.shop.service.impl;

import com.smart.shop.domain.dto.MemberDetailDto;
import com.smart.shop.domain.dto.MemberDto;
import com.smart.shop.domain.entity.Member;
import com.smart.shop.domain.entity.MemberDetail;
import com.smart.shop.mapper.MemberDetailMapper;
import com.smart.shop.mapper.MemberMapper;
import com.smart.shop.service.MemberService;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MemberSerivceImpl implements MemberService {
    @Resource
    MemberMapper memberMapper;

    @Resource
    MemberDetailMapper memberDetailMapper;

    @Override
    public List<Member> findAll(MemberDto memberDto, int page, int size) {
//        int limit = (page-1) * size;
        List<Member> members = memberMapper.selectAll(memberDto.getKeyword(), memberDto.getCreateDate(), (page - 1) * size, size);
        return members;
    }


    /**
     * 更新会员信息
     *
     * @param memberDto 更新的用户信息
     * @return
     */
    @Override
    @Transactional  //开启事务
    public int updateMember(MemberDto memberDto) {
        //先保存主表数据
        //Dto转换成Entity对象  copyProperties 拷贝对象
        Member member = new Member();
        /**
         * 等价于 member.setUsername(memberDto.getUsername)
         */
        //参数一 memberDto ： 要拷贝的对象
        //参数二 member : 目标对象
        BeanUtils.copyProperties(memberDto, member);
        int cout = memberMapper.update(member);

        //再保存子表数据
        MemberDetail memberDetail = new MemberDetail();
        BeanUtils.copyProperties(memberDto.getDetailDto(), memberDetail);
        memberDetailMapper.updateByPrimaryKeySelective(memberDetail);


        return cout;
    }
}
