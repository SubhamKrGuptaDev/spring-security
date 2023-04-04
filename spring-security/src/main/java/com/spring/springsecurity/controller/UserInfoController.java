package com.spring.springsecurity.controller;

import com.spring.springsecurity.entity.UserInfo;
import com.spring.springsecurity.servie.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auth")
public class UserInfoController {

    @Autowired
    private UserInfoService service;

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/getAll")
    public ResponseEntity<List<UserInfo>> getAll() {
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(service.getAll());
    }

    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    @GetMapping("/getByUserName/{username}")
    public ResponseEntity<UserInfo> getByUserName(@PathVariable String username) {
        return ResponseEntity.ok(service.getSingle(username));
    }

    @PostMapping("/create")
    public ResponseEntity<UserInfo> create(@RequestBody UserInfo user) {
        return ResponseEntity.ok(service.create(user));
    }

}






