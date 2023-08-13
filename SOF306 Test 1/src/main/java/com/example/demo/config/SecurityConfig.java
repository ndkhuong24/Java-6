package com.example.demo.config;

//@Configuration
//@EnableWebSecurity
public class SecurityConfig {
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Bean
//    public UserDetailsService authentication() {
//        PasswordEncoder encoder = passwordEncoder();
//
//        UserDetails user = User.builder()
//                .username("sa")
//                .password(encoder.encode("123"))
//                .roles("ADMIN")
//                .build();
//        return new InMemoryUserDetailsManager(user);
//    }
//
//    @Bean
//    public SecurityFilterChain authorization(HttpSecurity httpSecurity) throws Exception {
//        httpSecurity
//                .authorizeHttpRequests(req -> req
//                        .requestMatchers("/khach-hang/**")
//                        .hasRole("ADMIN")
//                        .anyRequest().permitAll())
//                .formLogin(login -> login
//                        .loginProcessingUrl("/login"))
//                .logout(logout -> logout
//                        .logoutSuccessUrl("/login"));
//        return httpSecurity.build();
//    }
}
