package com.skyline.controller;

import com.skyline.dto.UserDTO;
import com.skyline.service.oracle.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;

@RestController
public class LoginController implements Serializable {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserService userService;

    @PostMapping("/login")
    public ResponseEntity<Authentication> login(@RequestBody LoginRequest loginRequest) {
        Authentication authenticationRequest = UsernamePasswordAuthenticationToken.unauthenticated(loginRequest.username(), loginRequest.password());
        Authentication authenticationResponse = this.authenticationManager.authenticate(authenticationRequest);
        return ResponseEntity.ok(authenticationResponse);
    }

    @PostMapping("/autentication/new")
    public ResponseEntity<Authentication> login(@RequestBody UserDTO user) {
        UserDTO userSave = userService.newUser(user);
        Authentication authenticationRequest = UsernamePasswordAuthenticationToken.unauthenticated(userSave.getName(), userSave.getPassword());
        Authentication authenticationResponse = this.authenticationManager.authenticate(authenticationRequest);
        return ResponseEntity.ok(authenticationResponse);
    }

    // Endpoint for authenticated users with ROLE_USER
    @GetMapping("/user/dashboard")
    @PreAuthorize("hasRole('USER')")
    public String userDashboard() {
        return "Welcome to the user dashboard!";
    }

    // Endpoint for authenticated users with ROLE_ADMIN
    @GetMapping("/admin/dashboard")
    @PreAuthorize("hasRole('ADMIN')")
    public String adminDashboard() {
        return "Welcome to the admin dashboard!";
    }

    public record LoginRequest(String username, String password) {}

//    @Autowired
//    JWTAuthtenticationConfig jwtAuthtenticationConfig;

//    @PostMapping("login")
//    public User login(
//            @RequestParam("user") String username,
//            @RequestParam("encryptedPass") String encryptedPass) {
//
//        /**
//         * En el ejemplo no se realiza la correcta validación del usuario
//         */
//
//        String token = jwtAuthtenticationConfig.getJWTToken(username);
//        return new User(username, encryptedPass,token);
//
//    }

}