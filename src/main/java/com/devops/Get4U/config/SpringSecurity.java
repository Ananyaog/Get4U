package com.devops.Get4U.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;

import com.devops.Get4U.service.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity

public class SpringSecurity extends WebSecurityConfiguration
{
     @Autowired
     private UserDetailsServiceImpl userDetailsService;

     protected void configure(HttpSecurity http) throws Exception // Method chaining is possible
     {
       http.authorizeRequests()
       .antMatchers("/entity/**").authenticated()
       .anyRequest().permitAll()
       .and()
       .httpBasic();
     }

     protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
     }

     @Bean
     public PasswordEncoder passwordEncoder()
     {
        return new BCryptPassswordEncoder(); // Password converted to hash
     }
}
