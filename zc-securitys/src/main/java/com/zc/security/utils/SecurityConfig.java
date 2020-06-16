package com.zc.security.utils;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class SecurityConfig  extends WebSecurityConfigurerAdapter {
    //控制请求访问权限
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //定制请求授权规则
        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/level1/**").hasRole("VIP1")
                .antMatchers("/level2/**").hasRole("VIP2")
                .antMatchers("/level3/**").hasRole("VIP3");
        //开启自动配置的登录功能
        //1、login请求来到登录页面
        //2、重定向/login?Error表示登录失败
        //3、设置转到我们自己的登录界面
        //4、自定义的登录界面要发送post请求，action需要为/login，字段要匹配这里的
        //http.formLogin().usernameParameter("username").passwordParameter("password").loginPage("/userlogin");//.loginProcessingUrl("/login")
        http.formLogin().loginPage("/userlogin");
        //开启自动配置的注销功能
        //1、访问logout表示用户注销，清空session
        //2、默认注销成功会返回login?logout页面
        //3、设置注销成功来到首页
        http.logout().logoutSuccessUrl("/");
        //开启记住我功能
        http.rememberMe().rememberMeParameter("remember");
    }

    //定义认证规则
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
                .withUser("zhangsan").password(new BCryptPasswordEncoder().encode("123456"))
                .roles("VIP1", "VIP2")
                .and()
                .withUser("lisi").password(new BCryptPasswordEncoder().encode("123456"))
                .roles("VIP2", "VIP3");
    }
}