package com.Tsheps.VolunteerManagementApp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public PasswordEncoder encodePassword(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSec){
        return httpSec
                .csrf(AbstractHttpConfigurer::disable)//Disabling verification via sessionID
                .authorizeHttpRequests(request -> request.anyRequest().authenticated())//Page/api cannot be accessed without auth
                .httpBasic(Customizer.withDefaults())//Enables REST Api access
                .formLogin(Customizer.withDefaults())//Enables the default Form login in browser
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .build();
    }
//
//@Bean
//    public UserDetailsService useDetailsService(){
//return InMemoryUserDetailsManager;
//}
    //the UsernamePasswordAuthenticatioFilter uses the UserDetailService to authenticate username and password

}
