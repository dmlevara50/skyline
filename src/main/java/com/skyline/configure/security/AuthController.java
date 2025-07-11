package com.skyline.configure.security;

import com.skyline.dao.interfaces.oracle.IUserRepository;
import com.skyline.entity.oracle.UserEntity;
import com.skyline.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    IUserRepository iUserRepository;
    @Autowired
    PasswordEncoder encoder;
    @Autowired
    JwtUtil jwtUtils;
    @PostMapping("/signin")
    public String authenticateUser(@RequestBody User user) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        user.getUser(),
                        user.getPass()
                )
        );
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        return jwtUtils.generateToken(userDetails.getUsername());
    }
    @PostMapping("/signup")
    public String registerUser(@RequestBody User user) {
        Optional<UserEntity> userEntity = iUserRepository.findAllByName(user.getUser());
        if (userEntity.isPresent()) {
            return "Error: Username is already taken!";
        }
        // Create new user's account
        UserEntity newUser = new UserEntity();
        newUser.setIdUserEntity(4L);
        newUser.setName(user.getUser());
        newUser.setPass(encoder.encode(user.getPass()));
        newUser.setEmail(user.getEmail());
        newUser.setRol(2L);
        iUserRepository.saveAndFlush(newUser);
        return "User registered successfully!";
    }
}
