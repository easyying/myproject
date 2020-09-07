package com.daguo.advanced.exception;

import com.daguo.method1and2.ErrorResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * 定义全局异常捕获
 * 指定接受特定类抛出的特定异常进行处理！！！
 *
 * 这种方式是：不用每个方法最外层都try catch 同一由这里拦截然后处理返回给客户端
 */
@ControllerAdvice(assignableTypes = {Exception1Controller.class})//指定特定类抛出的异常
@ResponseBody
public class GlobalExceptionHandler1 {
    /**
     *ResourceNotFoundException异常会被哪个处理方法捕获 实则是handleResourceNotFoundException
     * getMappedMethod()会首先找到可以匹配处理异常的所有方法信息，然后对其进行从小到大的排序，最后取最小的那一个匹配的方法(即匹配度最高的那个)。
     */
  /*  @ExceptionHandler(value = BaseException.class)//拦截BaseException异常
    public ResponseEntity<?> handleAppException(BaseException e, HttpServletRequest request){
        ErrorReponse_Result response = new ErrorReponse_Result(e,request.getRequestURI());
        System.out.println("enen");
        return new ResponseEntity<>(response, new HttpHeaders(), e.getError().getHttpStatus());
    }*/
   /* @ExceptionHandler(value = ResourceNotFoundException.class)//自定义
    public ResponseEntity<ErrorReponse_Result> handleResourceNotFoundException(ResourceNotFoundException ex, HttpServletRequest request) {
        ErrorReponse_Result errorReponse = new ErrorReponse_Result(ex, request.getRequestURI());
        System.out.println("enen");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorReponse);
    }*/

    @ExceptionHandler(value = BaseException.class)//拦截BaseException异常
    public ErrorReponse_Result handleAppException2(BaseException e, HttpServletRequest request){
        ErrorReponse_Result response = new ErrorReponse_Result(e,request.getRequestURI());
        System.out.println("enen");
        return response;
    }
}
