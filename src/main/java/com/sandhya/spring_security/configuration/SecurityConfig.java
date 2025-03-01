package com.sandhya.spring_security.configuration;

import com.sandhya.spring_security.service.UserInfoService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    //Authentication with Spring Security
    @Bean
    public UserDetailsService userDetailsService() {
//        UserDetails userDetails1 = User
//                .withUsername("sachamo")
//                .password(passwordEncoder.encode("pwd"))
//                .roles("ADMIN", "USER")
//                .build();
//        UserDetails userDetails2 = User
//                .withUsername("john")
//                .password(passwordEncoder.encode("pwd"))
//                .roles("USER")
//                .build();

//        return new InMemoryUserDetailsManager(userDetails1, userDetails2);

        return new UserInfoService();
    }

/* To avoid authenticationProvider exception. It processes an Authentication request and
retrieves the user details from a simple, read-only user DAO, the UserDetailsService. */
    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService());
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }

    //Password encoder to encode password for security purpose
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    //Authorization
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(authorizationManagerRequestMatcherRegistry ->
                        authorizationManagerRequestMatcherRegistry
                                .requestMatchers("/skus/welcome", "/users").permitAll()
                                .requestMatchers("/skus/**").authenticated())
                .formLogin(Customizer.withDefaults())
                .build();
    }
}
