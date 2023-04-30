package com.example.favnote.controller;

import com.example.favnote.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping( "/user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestParam("username") String username, @RequestParam("password") String password){
        try {
            userService.createNewUser(username, password);
            return ResponseEntity.ok("ok");
        } catch(Exception e){
            return new ResponseEntity<String>("user already exists", HttpStatusCode.valueOf(409));
        }
    }

    @GetMapping("/login")
    public ResponseEntity<?> login(@RequestParam("username") String username, @RequestParam("password") String password){
        try {
            return ResponseEntity.ok(userService.loginUser(username, password));
        } catch(Exception e){
            return new ResponseEntity<String>("username or password is incorrect", HttpStatusCode.valueOf(403));
        }
    }

    @GetMapping("/check")
    public ResponseEntity<?> checkCredentials(@RequestParam("token") String token) {
        if(userService.checkCredentials(token))
            return ResponseEntity.ok(true);
        else
            return ResponseEntity.ok(false);
    }

}
