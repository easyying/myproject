package com.daguo.filter;


import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 自定义过滤器1
 */
@Slf4j
public class MyFilter implements Filter {

    //初始化过滤器后执行的操作
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("初始化过滤器");
    }

    // 对请求进行过滤
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        log.info("过滤器开始对请求进行预处理：");
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        String requestUri = request.getRequestURI();
        log.info("请求的接口为：" + requestUri);
        long startTime = System.currentTimeMillis();
        //通过 doFilter 方法实现过滤功能；doFilter 方法执行结束后用户的请求已经返回
        chain.doFilter(servletRequest,response);
        long endTime = System.currentTimeMillis();
        log.info("该用户的请求已经处理完毕，请求花费的时间为：" + (endTime - startTime));
    }

    // 销毁过滤器后执行的操作，主要用户对某些资源的回收
    @Override
    public void destroy() {
        log.info("销毁过滤器");
    }
}
