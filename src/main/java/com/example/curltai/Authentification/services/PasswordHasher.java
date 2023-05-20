package com.example.curltai.Authentification.services;


public interface PasswordHasher {
    String hash(String password);
    boolean check(String hash, String rawPassword);
}
