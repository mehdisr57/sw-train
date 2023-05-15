package com.msrazavi.train.sw.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


/**
 * @author <a href="mailto:mehdisr57@gmail.com">Mehdi.S.Razavi</a>
 */
@Configuration
public class SecurityConfig {

    private final PasswordEncoder passwordEncoder;

    public SecurityConfig(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        final String password = "changeme";//must be fixed
        auth
                .inMemoryAuthentication()
                .withUser("admin")
                .password(passwordEncoder.encode(password))
                .authorities("ROLE_ADMIN")
                .and()
                .withUser("user")
                .password(passwordEncoder.encode(password))
                .authorities("ROLE_USER");
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                .cors()
                .and()
                .csrf().disable()
                .authorizeHttpRequests(requests -> requests.anyRequest().authenticated())
                .httpBasic(Customizer.withDefaults())
                .build();
    }
}
