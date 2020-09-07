package com.daguo.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 自定义过滤器2
 */
@Component
@Slf4j//springboot的日志默认打印在控制台 如果不加任何配置的话 无applicaiton.properties
public class MyFilter2 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("初始化过滤器2");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
//对请求进行预处理
        log.info("过滤器开始对请求进行预处理2：");//方便日志级别控制
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String requestUri = request.getRequestURI();
        System.out.println("请求的接口为2：" + requestUri);//不方便日志级别控制
        long startTime = System.currentTimeMillis();
        //通过 doFilter 方法实现过滤功能
        chain.doFilter(servletRequest, servletResponse);
        // 上面的 doFilter 方法执行结束后用户的请求已经返回
        long endTime = System.currentTimeMillis();
        System.out.println("该用户的请求已经处理完毕，请求花费的时间为2：" + (endTime - startTime));
    }

    @Override
    public void destroy() {
        log.info("销毁过滤器2");
    }
}
