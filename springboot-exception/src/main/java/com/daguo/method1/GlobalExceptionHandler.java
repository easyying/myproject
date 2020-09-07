package com.daguo.method1;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 新建异常处理类
 * 方法一：使用 @ControllerAdvice和@ExceptionHandler处理全局异常
 * 在类上加上@ControllerAdvice注解这个类就成为了全局异常处理类，
 * 当然也可以通过 assignableTypes 指定特定的 Controller 类，让异常处理类只处理特定类抛出的异常。
 */
@ControllerAdvice/*(assignableTypes = {ExceptionController.class})*/
@ResponseBody
public class GlobalExceptionHandler {
    //用自定义的错误类型：返回指定的错误
    ErrorResponse illegalArgumentResponse = new ErrorResponse(new IllegalArgumentException("参数错误!"));
    ErrorResponse businessResponse = new ErrorResponse(new BusinessException("自定义异常错误"));


    RuntimeException bException  = new BusinessException("自定义异常错误1");// 因为要统一返回类型

    //@ExceptionHandler 处理 Controller 级别的异常
   /* @ExceptionHandler(value = Exception.class)// 拦截所有异常, 这里只是为了演示，一般情况下一个方法特定处理一种异常
    public ResponseEntity<ErrorResponse> exceptionHandler(Exception e){
        if(e instanceof IllegalArgumentException){
            return ResponseEntity.status(400).body(illegalArgumentResponse);
        }else if(e instanceof BusinessException){
            return ResponseEntity.status(404).body(businessResponse);
        }
        return null;
    }*/


    @ExceptionHandler(value = Exception.class)// 拦截所有异常, 这里只是为了演示，一般情况下一个方法特定处理一种异常
    public ResponseEntity<RuntimeException> exceptionHandler1(Exception e){
        if(e instanceof BusinessException){
            return ResponseEntity.status(404).body(bException);
        }
        return null;
    }

}
