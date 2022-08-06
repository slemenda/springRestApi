package com.example.chiquita.controllers;

import com.example.chiquita.requests.RegisterRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class RegisterController {

    // [GET] /todos
    // [GET] /todos/{id}
    // [POST] /todos
    // [DELETE] /todos/{id}
    // [GET] /user/{userId}/todos/{id}

    @PostMapping("/user")
    public ResponseEntity<Object> registerUser(@RequestBody @Valid RegisterRequest request) {

        // service ktera nam zaregistruje uzivatele

        return ResponseEntity.ok().build();
    }
}
