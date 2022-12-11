package com.app.hai.controller;

import com.app.hai.model.UsersModel;
import com.app.hai.repository.UserRepo;
import com.app.hai.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/home")
public class UsersController {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private UsersService usersService;

    @GetMapping("/getAllUsers")
    public List<UsersModel> getAll(){
        return userRepo.findAll();
    }

    @PostMapping("/users")
    public ResponseEntity<String> addUsers(@RequestBody UsersModel usersModel){
        return usersService.addUser(usersModel);
    }

    @GetMapping("/users/{username}")
    public ResponseEntity<String> findUserByUserName(@PathVariable String username){
        return usersService.getUser(username);
    }

    @PostMapping("user/login")
    public ResponseEntity<String> checkValidUser(@RequestBody UsersModel usersModel){
        return usersService.checkUserInput(usersModel);
    }
}
