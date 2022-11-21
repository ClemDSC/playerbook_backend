package com.playerbook.demo.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.stream.Collectors;

public class JwtUtil {

    static final Algorithm JWT_ALGORITHM = Algorithm.HMAC256("jwtSecret".getBytes());

    public DecodedJWT verifyAndGetDecodedJWT(String authorizationHeader){
        String token = authorizationHeader.substring("Bearer ".length());
        JWTVerifier verifier = JWT.require(JWT_ALGORITHM).build();
        DecodedJWT decodedJWT = verifier.verify(token);

        return decodedJWT;
    }

    public JWTCreator.Builder JwtCommonBase(User user, HttpServletRequest request){
        return JWT.create()
                .withSubject(user.getUsername())
                .withExpiresAt(new Date(System.currentTimeMillis() + 60 * 60 * 1000))
                .withIssuer(request.getRequestURL().toString());
    }

    public JWTCreator.Builder JwtCommonBase(com.playerbook.demo.domains.user.User user, HttpServletRequest request){
        return JWT.create()
                .withSubject(user.getUsername())
                .withExpiresAt(new Date(System.currentTimeMillis() + 60 * 60 * 1000))
                .withIssuer(request.getRequestURL().toString());
    }

    public String getAccessToken(User user, HttpServletRequest request){
        return JwtCommonBase(user, request)
                .withClaim("roles", user.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
                .sign(JWT_ALGORITHM);
    }
}
