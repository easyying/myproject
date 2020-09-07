package com.daguo.method1;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 新建异常处理类
 * 方法一：使用 @ControllerAdvice和@ExceptionHandler处理全局异常
 */
@ControllerAdvice()
@ResponseBody
public class GlobalExceptionHandler {
    ErrorResponse illegalArgumentResponse = new ErrorResponse(new IllegalArgumentException("参数错误!"));
    ErrorResponse businessResponse = new ErrorResponse(new BusinessException("自定义异常错误"));

    @ExceptionHandler(value = Exception.class)// 拦截所有异常, 这里只是为了演示，一般情况下一个方法特定处理一种异常
    public ResponseEntity<ErrorResponse> exceptionHandler(Exception e){
        if(e instanceof IllegalArgumentException){
            return ResponseEntity.status(400).body(illegalArgumentResponse);
        }else if(e instanceof BusinessException){
            return ResponseEntity.status(404).body(businessResponse);
        }
        return null;
    }

}
