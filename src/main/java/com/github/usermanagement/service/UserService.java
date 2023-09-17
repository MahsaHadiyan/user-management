package com.github.usermanagement.service;

import com.github.usermanagement.entity.Users;
import com.github.usermanagement.encryption.SHA;
import com.github.usermanagement.jwt.wrapper.JWTGenerator;
import com.github.usermanagement.repository.IUserRepository;
import org.jose4j.jwk.RsaJsonWebKey;
import org.jose4j.jwt.JwtClaims;
import org.jose4j.jwt.consumer.JwtConsumer;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.SecureRandom;
import java.util.Arrays;

/**
 * Created by Mahsa.Hadiyan  Date: 9/12/2023   Time: 2:26 PM
 **/
@Service
public class UserService {

    IUserRepository userRepository;

    public UserService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    private static byte[] salt() {
        SecureRandom random = new SecureRandom();
        byte[] salt;
        salt = new byte[6];
        random.nextBytes(salt);
        return salt;
    }


    @Transactional
    public void registerUser(Users users) throws Exception {
        String passwordSha256 = SHA.getSHA256(users.getPassword());
        users.setPassword(passwordSha256);
        userRepository.save(users);
    }


    public String loginUser(Users users) throws Exception {
        Users foundUsers = userRepository.findUsersById(users.getId());
        if (foundUsers != null) {
            String passwordSha256 = SHA.getSHA256(users.getPassword());
            if (passwordSha256.equals(foundUsers.getPassword())) {
                RsaJsonWebKey rsaJsonWebKey = JWTGenerator.getInstance().getRsaJsonWebKey();
                JwtClaims claims = JWTGenerator.getInstance().getJwtClaims();
                String jwt = JWTGenerator.getInstance().getJwtSignature(rsaJsonWebKey, claims);
                JwtConsumer jwtConsumer = JWTGenerator.getInstance().getJwtConsumer(rsaJsonWebKey);
                boolean validate = JWTGenerator.getInstance().validate(jwt, jwtConsumer);
                if (validate) {
                    return jwt;
                }
            }

        }
        throw new Exception();
    }
}
