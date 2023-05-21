package com.example.curltai.Controller;

import com.example.curltai.Model.Users.User;
import com.example.curltai.Repository.UserRepository;
import com.example.curltai.Service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    private final UserRepository userRepository;
    private final UserService userService;

    public UserController(UserRepository userRepository, UserService userService) {
        this.userRepository = userRepository;
        this.userService = userService;
    }

    @GetMapping
    public List<User> getUsers() {
        // Получение списка всех пользователей
        return userRepository.findAll();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteUser(@PathVariable Long id) {
        // Удаление пользователя по указанному идентификатору
        userRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity getUserById(@PathVariable Long id, @RequestHeader("Authorization") String authorizationHeader) {
        // Извлечение токена из заголовка авторизации
        String token = authorizationHeader.substring(7); // Удаление "Bearer " из заголовка авторизации
        // Получение информации о пользователе с указанным идентификатором с проверкой валидности токена
        return userService.getUserByIdWithTokenValidation(id, token);
    }

}
