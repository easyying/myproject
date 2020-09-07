package com.daguo.advanced.exception;

import com.daguo.comp.ExceptionCodeConstant;
import org.springframework.util.ObjectUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * 系统中的异常类都要继承自这个类
 */
public abstract class BaseException extends RuntimeException{
    //异常枚举
    private  ErrorCode error = null;
    //异常变量
    private ExceptionCodeConstant codeConstant = null ;
    private  Map<String, Object> data = new HashMap<>();

    public BaseException(ErrorCode error,Map<String, Object> data){
        super(error.getMessage());
        this.error = error;
        if (!ObjectUtils.isEmpty(data)) {
            this.data.putAll(data);
        }
    }
    protected BaseException(ErrorCode error, Map<String, Object> data, Throwable cause) {
        super(error.getMessage(), cause);
        this.error = error;
        if (!ObjectUtils.isEmpty(data)) {
            this.data.putAll(data);
        }
    }
    public ErrorCode getError(){
        return error;
    }
    public  Map<String, Object> getData(){
        return data;
    }

}
