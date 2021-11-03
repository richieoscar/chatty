package com.richieoscar.chatty.controller;

import com.richieoscar.chatty.service.UserRegistrationService;
import com.richieoscar.chatty.storage.UserStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@CrossOrigin
@RequestMapping
public class UserController {

    @Autowired
    UserRegistrationService registrationService; 

    @GetMapping("/register/{username}")
    public ResponseEntity<Void>  registerUser(@PathVariable String username) {
        try {
            registrationService.registerUser(username);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().build();
    }

    @GetMapping("/fetchUsers")
    Set<String> getUsers(){
       return UserStorageService.getInstance().getUsers();
    }

}
