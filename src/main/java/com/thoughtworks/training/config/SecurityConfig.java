package com.thoughtworks.training.config;

import com.thoughtworks.training.filter.JwtTokenFilter;
import com.thoughtworks.training.service.UsernamePasswordUserDetailService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.annotation.Resource;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Resource
    private UsernamePasswordUserDetailService userDetail;
    @Resource
    private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
    @Resource
    private JwtTokenFilter tokenFilter;

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetail).passwordEncoder(passwordEncoder());
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws
            Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .csrf().disable()
                .authorizeRequests()
                .antMatchers(
                        "/user",
                        "/session",
                        "/user/**",
                        "/session/**",
                        "/order/**",
                        "/movie",
                        "/movie/**",
                        "/cinemas",
                        "/dates"
                )
                .permitAll()
                .anyRequest().authenticated()
                .and()
                .exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint)
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        httpSecurity.addFilterBefore(tokenFilter, UsernamePasswordAuthenticationFilter.class);
    }

//    @Override
//    public void configure(WebSecurity webSecurity) {
//        webSecurity.ignoring().antMatchers("/**");
//    }

//    @Override
//    public void configure(HttpSecurity httpSecurity) throws Exception {
//        UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
//        CorsConfiguration configuration = new CorsConfiguration();
//        configuration.addAllowedHeader("*");
//        configuration.addAllowedOrigin("*");
//        configuration.addAllowedMethod("*");
//        configuration.setAllowCredentials(true);
//        urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", configuration);
//        httpSecurity.antMatcher("/**").csrf().disable().cors().configurationSource(urlBasedCorsConfigurationSource);
//    }
}
