package com.smart.shop.handler;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

/**
 * 两个注解
 *
 * 在类上面使用@RestControllerAdvice
 * 在方法上使用@ExceptionHandler
 */
@RestController
public class GlobalExceptionHandler {
    @ExceptionHandler
    public void handlerException(Exception ex) {
        System.out.println(ex.getMessage());
    }
}


