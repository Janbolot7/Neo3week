package com.example.Neo3week.controller;

import com.example.Neo3week.models.Users;
import com.example.Neo3week.models.UsersInfo;
import com.example.Neo3week.service.UsersService;
import lombok.Data;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(name = "/users")
public class UserController {
    @Autowired
    private UsersService usersService;

    @PostMapping
    public ResponseEntity<String> createUser(@RequestBody Users users) {
        return usersService.createUser(users);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id){
        return usersService.deleteUserById(id);
    }

    @PutMapping(name = "/{id}")
    public ResponseEntity<String> updateUser(@RequestBody UsersInfo usersInfo, @PathVariable Long id){
        return usersService.updateUser(usersInfo, id);
    }
    @GetMapping(name = "{id}")
    public ResponseEntity<?> getUserById(@PathVariable Long id) {
        return usersService.getUserById(id);
    }

    @GetMapping
    public List<Users> getAllUsers(){
        return usersService.getAllUsers();
    }
}
