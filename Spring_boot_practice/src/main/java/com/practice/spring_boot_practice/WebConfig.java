package com.practice.spring_boot_practice;

import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 将静态资源映射到指定的路径
        registry.addResourceHandler("jquery-3.7.1.min.js")
                .addResourceLocations("classpath:/static/js/");
    }
}