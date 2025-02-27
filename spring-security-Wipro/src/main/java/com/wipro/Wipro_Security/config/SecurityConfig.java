package com.wipro.Wipro_Security.config;

import com.wipro.Wipro_Security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Autowired
    private customAutenticationSuccessHandler autenticationSuccessHandler;
    @Autowired
    private UserService  userDetailsService;
    @Bean
    public  SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        return http.csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(requests -> {
                    requests.requestMatchers("/v1").permitAll();
                    requests.requestMatchers("/register/**").permitAll();
                    requests.requestMatchers("/user/**").hasRole("USER");
                    requests.requestMatchers("/admin/**").hasRole("ADMIN");
                    requests.anyRequest().authenticated();})
                        .formLogin(httpSecurityFormLoginConfigurer -> {
                            httpSecurityFormLoginConfigurer
                                            .loginPage("/login")
                                            .successHandler(autenticationSuccessHandler)
                                            .permitAll();
                                })
                        .build();
    }
    @Bean
    public customAutenticationSuccessHandler autenticationSuccessHandler(){
        return new customAutenticationSuccessHandler();
    }
    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider provider=new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService);
        provider.setPasswordEncoder(passwordEncoder());
        return provider;
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}

