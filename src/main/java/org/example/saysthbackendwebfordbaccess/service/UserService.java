package org.example.saysthbackendwebfordbaccess.service;
import org.example.saysthbackendwebfordbaccess.businesslogic.security.VerificationProcessor;
import org.example.saysthbackendwebfordbaccess.dto.CreateUserRequestDto;
import org.example.saysthbackendwebfordbaccess.model.User;
import org.example.saysthbackendwebfordbaccess.repository.UserRepository;
import org.example.saysthbackendwebfordbaccess.security.JwtTokenProvider;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final VerificationProcessor verificationProcessor;
    private final JwtTokenProvider jwtTokenProvider;

    @Autowired
    public UserService(UserRepository userRepository, VerificationProcessor verificationProcessor, JwtTokenProvider jwtTokenProvider) {
        this.userRepository = userRepository;
        this.verificationProcessor = verificationProcessor;
        this.jwtTokenProvider = jwtTokenProvider;
    }


    public List getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserByUlid(String ulid) {
        return userRepository.findByUlid(ulid).orElseThrow(() -> new RuntimeException("User not found with UUID"));
    }

    public User getUserByName(String name) {
        return userRepository.findByName(name).orElseThrow(() -> new RuntimeException("User not found with name"));
    }

    public User saveUser(CreateUserRequestDto req) {
        String encodedPassword = verificationProcessor.encodePassword(req.getPassword());
        User user = new User(req.getName(), req.getEmail(), encodedPassword);
        return userRepository.save(user);
    }

    public String compareUserAndGetToken(String email, String rawPassword) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found with email"));

        if (verificationProcessor.isPasswordMatching(rawPassword, user.getPassword())) {
            String userToken = this.jwtTokenProvider.createToken(user.getName());
            return userToken;
        } else {
            return "Invalid credentials";
        }
    }
}