package org.example.saysthbackendwebfordbaccess.config;

import org.example.saysthbackendwebfordbaccess.businesslogic.security.VerificationProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class VerificationConfig {
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Bean
    public VerificationProcessor verificationProcessor(PasswordEncoder passwordEncoder) {
        return new VerificationProcessor(passwordEncoder);
    }
}