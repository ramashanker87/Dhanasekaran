package com.dhana.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SecurityConfig {

    @Bean
    public UserDetailsService userDetailsService(){
        UserDetails doctor = User.withUsername("doctor1")
                .password(passwordEncoder()
                        .encode("password1"))
                .roles("DOCTOR").build();
        UserDetails patient = User.withUsername("patient1")
                .password(passwordEncoder()
                        .encode("password1"))
                .roles("PATIENT").build();
        return new InMemoryUserDetailsManager(doctor,patient);
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                                .requestMatchers("/patient/get/all/patient").hasRole("PATIENT")
                                .requestMatchers("/patient/get/patient").hasRole("PATIENT")
                                .requestMatchers("/patient/create/patient").hasRole("DOCTOR")
                                .requestMatchers("/patient/update/patients").hasRole("DOCTOR")
                                .requestMatchers("/patient/delete/patients").hasRole("DOCTOR")
                                .requestMatchers("/actuator/health").hasRole("PATIENT")
                                .anyRequest().authenticated()).httpBasic(withDefaults());
        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager (AuthenticationConfiguration authConfig) throws Exception {
        return authConfig.getAuthenticationManager();
    }
}