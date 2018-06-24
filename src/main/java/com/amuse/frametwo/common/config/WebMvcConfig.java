package com.amuse.frametwo.common.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @ClassName WebMvcConfig
 * @Description TODO
 * @Author 刘培振
 * @Date 2018/6/9 22:14
 * @Version 1.0
 */
@Configuration
//@EnableWebMvc  //会开启一些ViewResolver默认配置
public class WebMvcConfig extends WebMvcConfigurerAdapter {

    //和controller作用一样
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        super.addViewControllers(registry);
        //使用thymeleaf组件的跳转方式
        registry.addViewController("/login").setViewName("login");
        //没有使用thymeleaf组件的跳转方式
        //registry.addViewController("/login").setViewName("login.html");
    }
}
