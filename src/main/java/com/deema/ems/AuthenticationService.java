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

    private static final String SECRET_KEY = "your-secret-key"; // Use a more secure key in production
    private static final long EXPIRATION_TIME = 864_000_000; // 10 days

    @Autowired
    private UserRepository userRepository;

    public String authenticate(String username, String password) {
        // Validate user credentials (you should retrieve the user from the database)
        User user = userRepository.findByUsername(username);
        if (user == null || !user.getPassword().equals(password)) {
            throw new RuntimeException("Invalid username or password");
        }

        // Generate JWT token
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS512, SECRET_KEY)
                .compact();
    }
}
