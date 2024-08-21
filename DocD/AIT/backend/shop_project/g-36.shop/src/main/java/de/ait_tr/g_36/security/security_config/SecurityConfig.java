package de.ait_tr.g_36.security.security_config;

import de.ait_tr.g_36.security.security_filter.TokenFilter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableMethodSecurity

public class SecurityConfig {

  // field - наш собственный фильтр
  private TokenFilter filter;

  // constructor
  public SecurityConfig(TokenFilter filter) {
    this.filter = filter;
  }

  @Bean
  public BCryptPasswordEncoder encoder(){
    return new BCryptPasswordEncoder();
  }

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    return http
        .csrf(AbstractHttpConfigurer::disable)
        .sessionManagement(x -> x.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
        .httpBasic(AbstractHttpConfigurer::disable)
        .addFilterAfter(filter, UsernamePasswordAuthenticationFilter.class)
        .authorizeHttpRequests(x -> x
            .requestMatchers(HttpMethod.GET, "/products/all").permitAll()
            .requestMatchers(HttpMethod.GET, "/products").hasAnyRole("ADMIN", "USER")
            .requestMatchers(HttpMethod.POST, "/products").hasRole("ADMIN")
            .requestMatchers(HttpMethod.POST, "/auth/login", "/auth/refresh").permitAll()
        ).build();
  }
}
