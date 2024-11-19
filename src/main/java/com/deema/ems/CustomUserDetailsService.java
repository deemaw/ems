package com.deema.ems;

import com.deema.ems.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    // Inject your repository or data source here
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Fetch user from database
        com.deema.ems.user.User appUser = userRepository.findByUsername(username);

        // Map your user to Spring Security's UserDetails
        return User.builder()
                .username(appUser.getUsername())
                .password(appUser.getPassword()) // Ensure this is already encoded
//                .roles(appUser.getRoles().toArray(new String[0])) // Set user roles
                .build();
    }
}

