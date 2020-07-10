package com.smart.shop.aop;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.http.ResponseEntity;

@Aspect
public class GlobalExAspect {

//    @Pointcut(value = "execution(* * com.smart.shop.controller.*.)")
    public void pointcut() {

    }

    @AfterThrowing
    public ResponseEntity afterThrowing(Exception exception){
//        return com.smart.shop.utils.ResponseEntity.error();
        return null;
}
}
