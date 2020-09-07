package com.daguo.advanced.comp;

import lombok.Getter;
import lombok.Setter;

/**
 * 自定义异常
 */
@Setter
@Getter
public class BusinessException extends RuntimeException {
    private String code;
    public BusinessException(){

    }
    public BusinessException(String message){
       super(message);
    }

    public BusinessException(String code,String message){
        super(message);
        this.code = code;
    }
    public BusinessException(Throwable cause) {
        super(cause);
    }
    public BusinessException(String code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }
}
