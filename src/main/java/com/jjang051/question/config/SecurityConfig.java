package com.jjang051.question.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        //암호화하면서 인서트를 헤준다.
        return new BCryptPasswordEncoder();
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web->web.ignoring().requestMatchers(
                "/css/**",
                "/js/**",
                "/images/**",
                "/h2-console/**"
            )
        );
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity)
            throws Exception {
        httpSecurity.authorizeHttpRequests((auth)->auth
                .requestMatchers(
                        "/",
                        "/member/signin",
                        "/member/login"
                )
                .permitAll()
                .anyRequest().authenticated()
        );
        httpSecurity.formLogin((auth)->auth
                .loginPage("/member/login")
                .loginProcessingUrl("/member/login")  //우리가
                .usernameParameter("userId")          //username
                .passwordParameter("password")        //password
                .defaultSuccessUrl("/board/list",true)
                .permitAll()
        );
        httpSecurity.logout((auth)->auth
                .logoutRequestMatcher(
                        new AntPathRequestMatcher("/member/logout"))
                .logoutSuccessUrl("/")
                .invalidateHttpSession(true)
        );
        //필터 설정을 여기다가 하면 된다.
        return httpSecurity.build();
    }
}
