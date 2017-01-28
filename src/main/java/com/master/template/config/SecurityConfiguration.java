package com.master.template.config;

import com.master.template.security.*;
import com.master.template.service.AuthenticationService;

import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.data.repository.query.SecurityEvaluationContextExtension;
import org.springframework.security.web.session.HttpSessionEventPublisher;

import javax.inject.Inject;

@Configuration
@EnableWebSecurity
@ComponentScan(basePackageClasses = AuthenticationService.class)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Inject
    private Http401UnauthorizedEntryPoint authenticationEntryPoint;

    @Inject
    private AuthenticationService authenticationService;


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Inject
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(authenticationService)
                .passwordEncoder(passwordEncoder());
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
                .antMatchers(HttpMethod.OPTIONS, "/**")
                .antMatchers("/app/**/*.{js,html}")
                .antMatchers("/i18n/**")
                .antMatchers("/swagger-ui/index.html")
                .antMatchers("/test/**");

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.sessionManagement().maximumSessions(1).maxSessionsPreventsLogin(true)
                .and()
                .invalidSessionUrl("/login?expired");
        http.authorizeRequests()
                .antMatchers(
                        "/login*", "/logout","/registration",
                        "/img/**",
                        "/static/**",
                        "/asset*/**"
                )

                .permitAll().anyRequest().authenticated().and()
                .headers().frameOptions().disable().and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .defaultSuccessUrl("/index", true).and()
                .logout().logoutSuccessUrl("/login?logout")
                .and()
                .exceptionHandling().accessDeniedPage("/login?error").and()
                .csrf().disable();

    }

    @Bean
    public static ServletListenerRegistrationBean httpSessionEventPublisher() {
        return new ServletListenerRegistrationBean(new HttpSessionEventPublisher());
    }
}
