package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService authentication() {
        PasswordEncoder encoder = passwordEncoder();

        UserDetails user = User.builder()
                .username("sa")
                .password(encoder.encode("123"))
                .roles("ADMIN")
                .build();
        return new InMemoryUserDetailsManager(user);
    }

    @Bean
    public SecurityFilterChain authorization(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .authorizeHttpRequests(req -> req
                        .requestMatchers("/khach-hang/**")
                        .hasRole("ADMIN")
                        .anyRequest().permitAll())
                .formLogin(login -> login
                        .loginProcessingUrl("/login"))
                .logout(logout -> logout
                        .logoutSuccessUrl("/login"));
        return httpSecurity.build();
    }
}
