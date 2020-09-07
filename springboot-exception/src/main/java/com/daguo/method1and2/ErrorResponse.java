package com.daguo.method1and2;


import lombok.Getter;
import lombok.Setter;

/**
 * 新建异常信息实体类
 */
@Getter
@Setter
public class ErrorResponse {
    private String message;
    private String errorTypeName;

    public ErrorResponse(Exception e){
        this(e.getClass().getName(), e.getMessage());
    }

    public ErrorResponse(String errorTypeName, String message) {
        this.errorTypeName = errorTypeName;
        this.message = message;
    }


}
