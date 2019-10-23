package com.vg.translations.config;

import com.vg.translations.rest.CustomAccessDeniedHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.access.AccessDeniedHandler;

/**
 * @author vgrigoriev (vladimir.grigoriev@codefactorygroup.com) 10/21/2019
 */

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("user")
                .password("{noop}password")
                .roles("USER")
                .and().withUser("admin").password("{noop}password").roles("ADMIN");
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/translation/**","/translation").hasRole("ADMIN")
                .anyRequest().authenticated()
                .and().httpBasic()
                .and().exceptionHandling().accessDeniedHandler(accessDeniedHandler())
                .and().csrf().disable();

//                .and().formLogin();

    }

    @Bean
    public AccessDeniedHandler accessDeniedHandler(){
        return new CustomAccessDeniedHandler();
    }

//    @Override
//    public void configure(WebSecurity web) throws Exception {
////        web.ignoring().antMatchers("/translation");
//    }
}
