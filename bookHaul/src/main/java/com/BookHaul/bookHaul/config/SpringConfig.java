package com.BookHaul.bookHaul.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SpringConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        return
                http.authorizeHttpRequests(
                                auth -> {
                                    auth.requestMatchers("/").permitAll();
                                    auth.anyRequest().authenticated();
                                })
                        .httpBasic(withDefaults())
                        .oauth2Login(withDefaults())
//                        .formLogin(withDefaults())
                        .build();
    }
}
