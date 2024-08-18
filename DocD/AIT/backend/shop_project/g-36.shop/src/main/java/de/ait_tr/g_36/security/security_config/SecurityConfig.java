package de.ait_tr.g_36.security.security_config;

import de.ait_tr.g_36.domain.entity.Customer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

/**
 * 18/08/2024 g-36.shop * @author Boris Iurciuc (cohort36)
 */

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

  @Bean
  public BCryptPasswordEncoder encoder() {
    return new BCryptPasswordEncoder();
  }

  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception  {
    return http
        .csrf(AbstractHttpConfigurer::disable)
        .sessionManagement(x -> x
            .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED))
        .httpBasic(Customizer.withDefaults())
        .authorizeHttpRequests(x -> x
            .requestMatchers(HttpMethod.GET, "/products/test").permitAll()
//            .requestMatchers(HttpMethod.GET, "/products/all").permitAll()
//            .requestMatchers(HttpMethod.GET, "/products").hasAnyRole("ROLE-ADMIN", "ROLE-USER")
//            .requestMatchers(HttpMethod.POST, "/products").hasRole("ROLE-ADMIN")
        ).build();

  }

}
