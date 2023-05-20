package com.example.curltai.Repository;

import com.example.curltai.Model.Users.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    User save(User user);
    Optional<User> findById(Long id);
    boolean existsById(Long id);
    List<User> findAll();
    List<User> findAllById(Iterable<Long> user);
    long count();
    void deleteById(Long id);
    void delete(User user);
    void deleteAll();
    User findByLogin(String login);
    User findByEmail(String email);
}