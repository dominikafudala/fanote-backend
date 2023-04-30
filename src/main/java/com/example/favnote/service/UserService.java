package com.example.favnote.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.favnote.entity.User;
import com.example.favnote.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class UserService {
    private static Algorithm SIGNATURE_ALGORITHM = Algorithm.HMAC256("secret".getBytes());
    private static final JWTVerifier verifier = JWT.require(SIGNATURE_ALGORITHM).build();
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public void createNewUser(String username, String password) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password));

        userRepository.save(user);
    }

    public String loginUser(String username, String password) throws Exception {
        User user = userRepository.findByUsername(username);


        if(passwordEncoder.matches(password, user.getPassword())){
            return this.createTokenFromUsername(username);
        } else {
            throw new Exception("bad password");
        }
    }

    private String createTokenFromUsername(String username) {
        String access_token = JWT.create()
                .withSubject(username)
                .withIssuer("favnote")
                .sign(SIGNATURE_ALGORITHM);

        return access_token;
    }

    public boolean checkCredentials(String token){
        try{
            DecodedJWT decodedJWT = verifier.verify(token);
            String username = decodedJWT.getSubject();
            if(userRepository.findByUsername(username) != null) {
                return true;
            }
            return false;
        }catch(Exception e){
            return false;
        }
    }
}
