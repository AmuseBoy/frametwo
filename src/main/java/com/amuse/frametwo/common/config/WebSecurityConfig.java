package com.amuse.frametwo.common.config;

import com.amuse.frametwo.service.impl.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @ClassName WebSecurityConfig
 * @Description TODO
 * @Author 刘培振
 * @Date 2018/6/8 17:40
 * @Version 1.0
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //super.configure(auth);
//        auth
//                .inMemoryAuthentication()
//                .withUser("admin").password("123456").roles("admin");
        auth
                .userDetailsService(userDetailsService)
                .passwordEncoder(new BCryptPasswordEncoder());//对传入的密码加密
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        //super.configure(web);
        //web.ignoring().antMatchers("favicon.ico","/js/**","/css/**","/img/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //super.configure(http);
        http
                //.httpBasic()    //spring security基本验证方式，请求头Base64加密，Authorization:Basic bWFyczpsb28=
                .formLogin()    //表单验证方式
                .loginPage("/login")   //可以直接资源访问(login.html),也可以接口跳转到login.html页面
                .loginProcessingUrl("/login")    //登陆处理请求默认值 == loginPage的值
                //.defaultSuccessUrl("/index.html")    //登陆成功跳转页面
                //.failureUrl("/login?error")    //登陆失败跳转的页面,还是当前页面
//                .successHandler(new RestAuthenticationSuccessHandler())
//                .failureHandler()
//                .successForwardUrl("/index.html")

                .permitAll()   //登陆请求的地址 都允许访问
                .and()
                .authorizeRequests()    //权限配置
                .antMatchers("favicon.ico","/js/**","/css/**","/img/**").permitAll() //静态资源都可以访问
                .anyRequest().authenticated() //任何请求都需要身份认证
                .and()
                .csrf().disable();
    }
}
