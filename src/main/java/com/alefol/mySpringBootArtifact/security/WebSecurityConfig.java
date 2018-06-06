package com.alefol.mySpringBootArtifact.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.Http401AuthenticationEntryPoint;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.alefol.mySpringBootArtifact.service.UserService;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	UserService userService;
	
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService);
    }
	
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf()
        .disable()
        .exceptionHandling()
        .authenticationEntryPoint(new Http401AuthenticationEntryPoint("App header"))
        .and()
        .authenticationProvider(getProvider())
        .formLogin()
        .loginProcessingUrl("/login")
        .and()
        .logout()
        .logoutUrl("/logout")
        .invalidateHttpSession(true)
        .and()
        .authorizeRequests()
        .antMatchers("/login").permitAll()
        .antMatchers("/logout").permitAll()
        .antMatchers("/personne").permitAll()
        .anyRequest().permitAll();
    }

    @Bean
    public AuthenticationProvider getProvider() {
        AppAuthProvider provider = new AppAuthProvider();
        provider.setUserDetailsService(userService);
        return provider;
    }
}