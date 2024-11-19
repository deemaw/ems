package com.deema.ems;

import com.deema.ems.user.UserLoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody UserLoginRequest loginRequest) {
        try {
            // Authenticate the user and generate a token
            String token = authenticationService.authenticate(loginRequest.getUsername(), loginRequest.getPassword());

            // Return the token
            return ResponseEntity.ok(new AuthenticationResponse(token));
        } catch (Exception e) {
            // Handle authentication failure
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
        }
    }
}

