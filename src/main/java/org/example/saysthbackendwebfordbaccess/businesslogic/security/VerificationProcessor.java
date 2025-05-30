package org.example.saysthbackendwebfordbaccess.businesslogic.security;

import org.springframework.security.crypto.password.PasswordEncoder;


public class VerificationProcessor {
    private final PasswordEncoder passwordEncoder;

    public VerificationProcessor(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    public boolean isPasswordMatching(String basePassword, String targetPassword) {
        boolean isMatching = this.passwordEncoder.matches(basePassword, targetPassword);
        return isMatching;
    }

    public String encodePassword(String rawPassword) {
        return this.passwordEncoder.encode(rawPassword);
    }
}
