package com.leiyuan.bs;

import com.leiyuan.bs.interceptor.MyHandlerInterceptor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Component
public class MyWebMvcConfigurerAdapter extends WebMvcConfigurerAdapter {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        /**
         * 这里的addPathPatterns("/**")为配置需要拦截的方法“/**”代表所有，而后excludePathPatterns("/user/toLogin")等方法为排除哪些方法不进行拦截
         */
        registry.addInterceptor(new MyHandlerInterceptor()).excludePathPatterns("/user/toLogin").excludePathPatterns
                ("/user/login").excludePathPatterns("/user/toNewUser").excludePathPatterns("/user/newUser");
        super.addInterceptors(registry);
    }
}
