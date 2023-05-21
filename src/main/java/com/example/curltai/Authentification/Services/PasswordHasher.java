package com.example.curltai.Authentification.Services;


public interface PasswordHasher {
    String hash(String password);
    boolean check(String hash, String rawPassword);
}
