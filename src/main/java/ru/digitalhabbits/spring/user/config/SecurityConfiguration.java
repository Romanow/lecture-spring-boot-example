package ru.digitalhabbits.spring.user.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration
        extends WebSecurityConfigurerAdapter {
    public static final String API_USER = "test";
    public static final String API_PASSWORD = "test";
    public static final String API_ROLE = "CLIENT";

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http)
            throws Exception {
        http.requestMatcher(new AntPathRequestMatcher("/api/**"))
                .authorizeRequests()
                .anyRequest()
                .hasRole(API_ROLE)
                .and()
                .httpBasic()
                .and()
                .csrf().disable();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth)
            throws Exception {
        final PasswordEncoder encoder = passwordEncoder();
        auth.inMemoryAuthentication()
                .passwordEncoder(encoder)
                .withUser(API_USER)
                .password(encoder.encode(API_PASSWORD))
                .roles(API_ROLE);
    }
}
