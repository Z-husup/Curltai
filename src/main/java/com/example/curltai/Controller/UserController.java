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
        return userRepository.findAll();
    }

    @PostMapping("/new-user")
    public ResponseEntity createUser(@RequestBody User User) throws URISyntaxException {
        User savedUser = userRepository.save(User);
        return ResponseEntity.created(new URI("/" + savedUser.getId_user())).body(savedUser);
    }



    @PutMapping("/{id}")
    public ResponseEntity updateUser(@PathVariable Long id, @RequestBody User User) {
        User currentUser = userRepository.findById(id).orElseThrow(RuntimeException::new);
        currentUser.setLogin(User.getLogin());
        currentUser.setEmail(User.getEmail());
        currentUser = userRepository.save(User);

        return ResponseEntity.ok(currentUser);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteUser(@PathVariable Long id) {
        userRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity getUserById(@PathVariable Long id, @RequestHeader("Authorization") String authorizationHeader) {
        String token = authorizationHeader.substring(7); // Remove "Bearer " from the authorization header
        return userService.getUserByIdWithTokenValidation(id, token);
    }
}
