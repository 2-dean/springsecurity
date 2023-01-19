package com.demo.springsecurity.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity //default filter chain proxy 해제됨
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    //필터체인 프록시로 등록된 상태

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //http에 대한 보안설정
        http
                .authorizeRequests() //로그인설정
                    .antMatchers("/users/**").authenticated()// /users/** 요청은 인증이 필요함
                .anyRequest().permitAll() // 그외의 요청은 접근 허용
                    .and()
                .formLogin()    //form 방식으로로그인 하겠다
                    .and()
                .logout()
                    .and()
                .csrf().disable();
    }
}

