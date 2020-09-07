package com.daguo.advanced.exception;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.util.ObjectUtils;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

/**
 * 定义返回给客户端具体的异常对象(就是错误 Result)
 （返回给客户端不能抛出异常，就是返回对象（里面包含正确或者错误的信息））
 *
 * 注：
 返回的信息包含了异常下面 6 部分内容：
 唯一标示异常的 code
 HTTP状态码
 错误的具体信息
 消息体
 错误路径
 发生错误的时间戳
 */
@Getter
@Setter

public class ErrorReponse_Result<T> {

    private int status;//success
    private int code;
    private String message;
    private Map<String, Object> data = new HashMap<String, Object>();;
    private String path;
    private Instant timestamp;//Instant jdk 8

    public ErrorReponse_Result(BaseException ex, String path){
        this(ex.getError().getCode(), ex.getError().getHttpStatus().value(), ex.getError().getMessage(),ex.getData(), path);
    }
    public ErrorReponse_Result(int status, int code, String message, Map<String, Object> data, String path){
        this.status = status;
        this.code = code;
        this.message = message;
        if (!ObjectUtils.isEmpty(data)) {
            this.data.putAll(data);
        }
        this.path = path;
        this.timestamp = Instant.now();
    }

    @Override
    public String toString() {
        return "ErrorReponse_Result{" +
                "code=" + code +
                ", status=" + status +
                ", message='" + message + '\'' +
                ", path='" + path + '\'' +
                ", timestamp=" + timestamp +
                ", data=" + data +
                '}';
    }
}
