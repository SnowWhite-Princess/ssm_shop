package com.smart.shop.mapper;

import com.smart.shop.domain.entity.Member;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MemberMapper {

    /**
     *
     * @param keyword 搜索关键字
     * @param limit 起始索引
     * @param offset    返回多少条
     * @return
     */
    //不要传Dto的对象，DAO：一个Mapper对应一个表的操作
//    List<Member> selectAll(@Param("member") Member member, @Param("limit") int limit, @Param("offset") int offset);
    List<Member> selectAll(@Param("keyword") String keyword, @Param("createDate") String createDate, @Param("limit") int limit,@Param("offset") int offset);


    //保存数据到Member,因为entity操作的是数据库，保存到数据库，这里不要传Dto
    int update(Member member);

}
