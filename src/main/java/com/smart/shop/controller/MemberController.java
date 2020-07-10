package com.smart.shop.controller;

import com.smart.shop.domain.dto.MemberDto;
import com.smart.shop.domain.entity.Member;
import com.smart.shop.service.MemberService;
import com.smart.shop.utils.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController

//前缀
@RequestMapping("/admin/member")
public class MemberController {
    @Resource
    MemberService memberService;

    /**
     * 根据用户名 手机号 或者 时间进行分页查询
     * 对数据进行校验
     *
     * @param memberDto
     * @param page
     * @param size
     * @return
     */
    //多个条件建议封装成对象
    @PostMapping("/list")
    //设置默认值 @RequestParam(defaultValue = "1")
    public ResponseEntity<List<Member>> list(MemberDto memberDto, @RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int size) {
        List<Member> members = memberService.findAll(memberDto, page, size);
        return ResponseEntity.success(members);
    }


    @PostMapping("/update")
    //不要传Member，因为entity.Member是操作数据库的
    //@RequestBody 传json对象
    public ResponseEntity<Member> update(@RequestBody MemberDto memberDto) {

        return null;
    }


    //添加
    @PostMapping("/add")
    public ResponseEntity<Member> add() {
        return null;
    }

    //批量删除,用@PostMapping也可以
    @DeleteMapping("/batch")
    public ResponseEntity<Member> batchDel() {
        return null;
    }

    //根据ID删除
    @PostMapping("/del")
    public ResponseEntity<Member> delete(int id) {
        return null;
    }

    @PostMapping("/active")
    public ResponseEntity<Member> active(int id) {
        return null;
    }
}
