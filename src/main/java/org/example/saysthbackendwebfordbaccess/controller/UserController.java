package org.example.saysthbackendwebfordbaccess.controller;

import org.example.saysthbackendwebfordbaccess.model.User;
import org.example.saysthbackendwebfordbaccess.service.UserService;
import org.example.saysthbackendwebfordbaccess.dto.CreateUserRequestDto;
import org.example.saysthbackendwebfordbaccess.dto.SignInUserRequestDto;
import org.example.saysthbackendwebfordbaccess.dto.api.ApiResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public User createUser(@RequestBody CreateUserRequestDto req) {
        return userService.saveUser(req);
    }

    @PostMapping("/signIn")
    public ResponseEntity<ApiResponseDto<String>> signIn(@RequestBody SignInUserRequestDto req) {
        String userToken = this.userService.compareUserAndGetToken(req.getEmail(), req.getPassword());
        ApiResponseDto<String> response = new ApiResponseDto<>(true, userToken, "User signed-in Successfully");

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }


    @GetMapping
    public List<User> list() {
        return userService.getAllUsers();
    }

    @GetMapping("/{ulid}")
    public User findByUlid(@PathVariable String ulid) {
        return userService.getUserByUlid(ulid);
    }

    @GetMapping("/name")
    public User findByName(@RequestParam String name) {
        return userService.getUserByName(name);
    }
}
