package com.lrh.config;

import com.lrh.handler.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author lrh
 * @description
 * @date 2023/2/14
 */
@Configuration
public class WebmvcConfig implements WebMvcConfigurer {

    @Autowired
    private LoginInterceptor loginInterceptor;

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedHeaders("*")
                .allowedMethods("*")
                .maxAge(1800)
                .allowedOrigins("*");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(loginInterceptor)
            .addPathPatterns("/article/like")
            .addPathPatterns("/article/search")
            .addPathPatterns("/comments/add")
            .addPathPatterns("/follow/current/{page}")
            .addPathPatterns("/fans/current/{page}")
        ;

    }
}
