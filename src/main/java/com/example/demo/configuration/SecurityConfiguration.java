package com.example.demo.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter
{
    @Autowired
    private HandlerMappingIntrospector handlerMappingIntrospector;

    @Override
    public void configure(HttpSecurity http) throws Exception
    {
        var mvcMatcher = new MvcRequestMatcher(handlerMappingIntrospector, "/{firstname}/{lastname}");
        mvcMatcher.setMethod(HttpMethod.GET);

        http.authorizeRequests()
                .requestMatchers(mvcMatcher)
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .csrf()
                .ignoringRequestMatchers(mvcMatcher);
    }
}
