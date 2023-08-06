package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class AuthConfig extends WebSecurityConfiguration {
    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    /* Mã hóa mật khẩu */
    @Bean
    public BCryptPasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /* Quản lý dữ liệu người dùng */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("user1").password(passwordEncoder.encode("123")).roles("GUEST")
                .and()
                .withUser("user2").password(passwordEncoder.encode("123")).roles("GUEST", "USER")
                .and()
                .withUser("user3").password(passwordEncoder.encode("123")).roles("GUEST", "USER", "ADMIN");
    }

    /* Phân quyền sử dụng và hình thức đăng nhập */
    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf().disable().cors().disable();

        httpSecurity.authorizeRequests()
                .requestMatchers("/home/index").permitAll()
                .anyRequest().authenticated();

        httpSecurity.httpBasic();
    }
}
