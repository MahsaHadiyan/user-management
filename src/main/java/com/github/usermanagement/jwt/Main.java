package com.github.usermanagement.jwt;

import com.github.usermanagement.jwt.wrapper.JWTGenerator;
import org.jose4j.jwk.RsaJsonWebKey;
import org.jose4j.jwt.JwtClaims;
import org.jose4j.jwt.consumer.JwtConsumer;

public class Main {

    public static void main(String[] args) throws Exception {

        RsaJsonWebKey rsaJsonWebKey = JWTGenerator.getInstance().getRsaJsonWebKey();

        JwtClaims claims = JWTGenerator.getInstance().getJwtClaims();

        String jwt = JWTGenerator.getInstance().getJwtSignature(rsaJsonWebKey, claims);

        JwtConsumer jwtConsumer = JWTGenerator.getInstance().getJwtConsumer(rsaJsonWebKey);

        JWTGenerator.getInstance().validate(jwt, jwtConsumer);
    }


}