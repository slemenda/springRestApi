package com.example.chiquita.controllers;

import com.example.chiquita.model.ErrorResponse;
import com.example.chiquita.model.JwtRequest;
import com.example.chiquita.model.JwtResponse;
import com.example.chiquita.service.UserService;
import com.example.chiquita.utils.JwtUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/api/v1")
public class LoginController {

    private final UserService userService;

    private final AuthenticationManager authenticationManager;

    private final JwtUtils jwtUtils;

    public LoginController(
            UserService userService,
            AuthenticationManager authenticationManager,
            JwtUtils jwtUtils
        ) {
        this.userService = userService;
        this.authenticationManager = authenticationManager;
        this.jwtUtils = jwtUtils;
    }

    @PostMapping("/auth")
    public ResponseEntity<Object> login(@RequestBody JwtRequest jwtRequest) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            jwtRequest.username(),
                            jwtRequest.password()
                    )
            );
        } catch (BadCredentialsException e) {
            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body(new ErrorResponse("Invalid password or username"));
        }

        UserDetails userDetails = userService.loadUserByUsername(jwtRequest.username());
        String token = jwtUtils.generateToken(userDetails);

        return ResponseEntity.ok().body(new JwtResponse(token));
    }
}
