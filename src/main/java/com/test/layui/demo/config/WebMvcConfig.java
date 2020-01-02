package com.test.layui.demo.config;

import com.test.layui.demo.config.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Autowired
    private LoginInterceptor loginInterceptor;
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("forward:/test/login.html");
    }


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // addPathPatterns("/**") 表示拦截所有的请求，
        // excludePathPatterns("/login", "/register") 表示除了登陆与注册之外，因为登陆注册不需要登陆也可以访问
        String[] excludePathPatterns={"/","/login","/loginPage","/test/login.html","/layui/**","//checkUser","/test/register.html","/register"};
        registry.addInterceptor(loginInterceptor).excludePathPatterns(excludePathPatterns).addPathPatterns("/**");
        // super.addInterceptors(registry);    //较新Spring Boot的版本中这里可以直接去掉，否则会报错
    }




}