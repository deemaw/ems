package com.deema.ems;

import com.deema.ems.user.User;
import com.deema.ems.user.UserRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class AuthenticationService {

    private static final String SECRET_KEY = "";
    private static final long EXPIRATION_TIME = 864_000_000; // 10 days

    @Autowired
    private UserRepository userRepository;

    public AuthenticationResponse authenticate(String username, String password) {
        // Validate user credentials
        User user = userRepository.findByUsername(username);
        if (user == null ||  !user.getPassword().equals(password)) {
            throw new RuntimeException("Invalid username or password");
        }

        // Generate JWT token
        String token = Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();

        // Return AuthenticationResponse
        return new AuthenticationResponse(token, user.getRoles());
    }
}
