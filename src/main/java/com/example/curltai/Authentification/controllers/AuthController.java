package com.example.curltai.Authentification.controllers;

import com.example.curltai.Model.Users.User;
import com.example.curltai.Authentification.services.AuthService;
import com.example.curltai.Authentification.services.PasswordHasher;
import com.example.curltai.Service.UserService;
import com.example.curltai.Authentification.viewmodels.JwtResponse;
import com.example.curltai.Authentification.viewmodels.UserViewModel;
import jakarta.security.auth.message.AuthException;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class AuthController {

    private final AuthService authService;
    private final UserService userService;
    private final PasswordHasher passwordHasher;

    @GetMapping("login/{login}/{password}")
    public ResponseEntity login(@PathVariable String login, @PathVariable String password) {
        final Optional<JwtResponse> token = authService.login(login, password);

        if(token.isEmpty())
        {
            return  ResponseEntity.badRequest().body("Wrong password or login");
        }

        return ResponseEntity.ok(token);
    }

    @PostMapping("new-user")
    public ResponseEntity createUser(@RequestBody UserViewModel userVm) {
        User user;
        try {
            user = new User((long) -1, userVm.getLogin(), userVm.getEmail(), userVm.getPassword());
        } catch (IllegalArgumentException exc) {
            return ResponseEntity.badRequest().body("Incorrect role!");
        }

        if (user.getLogin() == null) {
            return ResponseEntity.badRequest().body("Require param login, doesn't exist");
        }

        if (user.getPassword() == null) {
            return ResponseEntity.badRequest().body("Require param password, doesn't exist");
        }

        if (userService.getByLogin(user.getLogin()).isPresent()) {
            return ResponseEntity.badRequest().body("The user with same login already exist!");
        }
        if (userService.getByEmail(user.getEmail()).isPresent()) {
            return ResponseEntity.badRequest().body("The user with same email already exist!");
        }

        userService.createUser(user, user.getPassword());
        return ResponseEntity.ok().build();
    }

    @PostMapping("token/{request}")
    public ResponseEntity getNewAccessToken(@PathVariable String request) {
        final JwtResponse token;
        try {
            token = authService.getAccessToken(request);
        } catch (AuthException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok(token);
    }

    @PostMapping("refresh/{request}")
    public ResponseEntity getNewRefreshToken(@PathVariable String request) {
        final JwtResponse token;
        try {
            token = authService.refresh(request);
        } catch (AuthException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok(token);
    }

}
