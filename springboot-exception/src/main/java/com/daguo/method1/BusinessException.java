package com.daguo.method1;

/**
 * 自定义异常类
 */
public class BusinessException extends RuntimeException{
    public String message;

    public BusinessException(){
        super();
    }
    public BusinessException(String message){
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage(){
        return message;
    }

    public void setMessage(String message){
        this.message = message;
    }

}
