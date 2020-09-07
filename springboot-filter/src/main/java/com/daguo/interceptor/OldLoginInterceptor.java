package com.daguo.interceptor;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 用户登录拦截器：
 * 如果用户输入已经被废弃的链接 ：
 * “ / admin / oldLogin”，它将重定向到新的 “ / admin / login”
 */
public class OldLoginInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        System.out.println("\n-------- OldLoginInterceptor.preHandle --- ");
        System.out.println("Request URL: " + request.getRequestURL());
        System.out.println("Sorry! This URL is no longer used, Redirect to /admin/login");

        response.sendRedirect(request.getContextPath() + "/admin/login");
        return false;
    }
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
        //不会运行下面的
        System.out.println("\n-------- OldLoginInterceptor.postHandle --- ");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
                                Exception ex) throws Exception {
        //不会运行下面的
        System.out.println("\n-------- QueryStringInterceptor.afterCompletion --- ");
    }
}
