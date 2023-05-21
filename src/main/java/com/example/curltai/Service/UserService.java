package com.example.curltai.Service;

import com.example.curltai.Authentification.services.JwtProvider;
import com.example.curltai.Authentification.services.PasswordHasher;
import com.example.curltai.Model.Users.User;
import com.example.curltai.Repository.UserRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordHasher passwordHasher;
    private final JwtProvider jwtProvider;


    public User getUserById(@NonNull Long id) {
        return userRepository.findById(id).orElse(null);
    }


    public Optional<User> getByLogin(@NonNull String login) {
        return Optional.ofNullable(userRepository.findByLogin(login));
    }
    public Optional<User> getByEmail(@NonNull String login) {
        return Optional.ofNullable(userRepository.findByEmail(login));
    }

    public boolean checkLoginAndPassword(@NonNull String login, @NonNull String password){
        var user = getByLogin(login);
        if(user.isEmpty()){
            return false;
        }
        return passwordHasher.check(user.get().getPassword(), password);
    }

    public void createUser(User user, String password){
        user.setPassword(passwordHasher.hash(password));
        userRepository.save(user);
    }

    public ResponseEntity getUserByIdWithTokenValidation(Long id, String token) {
        if (jwtProvider.validateAccessToken(token)) {
            // Token is valid, retrieve user from database and return the response
            User user = getUserById(id);
            if (user != null) {
                return ResponseEntity.ok(user);
            } else {
                return ResponseEntity.notFound().build();
            }
        } else {
            // Token is invalid or expired, return unauthorized response
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid or expired token");
        }
    }
