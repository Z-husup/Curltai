package com.example.curltai.Authentification.services;

import com.example.curltai.Model.Users.User;
import com.example.curltai.Repository.UserRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    private final PasswordHasher passwordHasher;
    public Optional<User> getByLogin(@NonNull String login) {
        return Optional.ofNullable(userRepository.findByLogin(login));
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

}