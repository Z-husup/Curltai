package com.example.curltai.Authentification.jwt;

import com.example.curltai.Authentification.jwt.JwtAuthentication;
import io.jsonwebtoken.Claims;

public final class JwtUtils {

    public static JwtAuthentication generate(Claims claims) {
        final JwtAuthentication jwtInfoToken = new JwtAuthentication();
        jwtInfoToken.setLogin(claims.get("login", String.class));
        jwtInfoToken.setUsername(claims.getSubject());
        return jwtInfoToken;
    }
}