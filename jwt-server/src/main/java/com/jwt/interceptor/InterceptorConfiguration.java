package com.jwt.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@SpringBootConfiguration
public class InterceptorConfiguration implements WebMvcConfigurer {
    @Autowired
    private HttpInterceptor httpInterceptor;

    @Autowired
    private JwtInterceptor jwtInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(httpInterceptor).addPathPatterns("/**");
        registry.addInterceptor(jwtInterceptor).addPathPatterns("/sys/**");
    }

}
