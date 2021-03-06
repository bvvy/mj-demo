package com.divide2.auth.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

/**
 * @author bvvy
 */
@Configuration
@EnableResourceServer
public class ResourceConfig extends ResourceServerConfigurerAdapter {
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers(
                        "/swagger*/**",
                        "/v2/api-docs",
                        "/webjars/**",
                        "/join",
                        "/v1/verify/code",
                        "/v1/user/exist",
                        "/v1/pwd/find").permitAll()
                .anyRequest().authenticated();
    }
}
