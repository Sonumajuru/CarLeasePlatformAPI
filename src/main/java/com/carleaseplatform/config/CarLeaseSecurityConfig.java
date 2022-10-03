package com.carleaseplatform.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * Config file for HTTP Basic authentication
 * Also for swagger API documentation
 * */
@Configuration
@EnableWebSecurity
public class CarLeaseSecurityConfig {

    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {
        UserDetails user = User.withDefaultPasswordEncoder()
                .username("simon")
                .password("admin")
                .roles("USER")
                .build();

        UserDetails admin = User.withDefaultPasswordEncoder()
                .username("admin")
                .password("admin")
                .roles("ADMIN")
                .build();

        return new InMemoryUserDetailsManager(user, admin);
    }

    /** HTTP Basic authentication */
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers(HttpMethod.GET, "/customers/**").hasRole("USER")
                .antMatchers(HttpMethod.POST, "/customers").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT, "/customers/{id}/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/customers/{id}/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/cars/**").hasRole("USER")
                .antMatchers(HttpMethod.POST, "/cars").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT, "/cars/{id}/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/cars/{id}/**").hasRole("ADMIN")
                .and()
                .csrf().disable()
                .formLogin();

        return http.build();
    }

    /** Integrating of Swagger 2 Into the Project */
    @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.carleaseplatform"))
                .paths(PathSelectors.any())
                .build();
    }
}