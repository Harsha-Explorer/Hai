package com.app.hai.service;

import com.app.hai.model.UsersModel;
import com.app.hai.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public class UsersService {
    @Autowired
    private UserRepo userRepo;
    public ResponseEntity<String> addUser(UsersModel usersModel) {
        try{
            userRepo.save(usersModel);
            return new ResponseEntity<>("Successfully registered. Now please Login",HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("User already exists. Please choose another username",HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<String> getUser(String username){
        try{
            UsersModel usersModel=userRepo.findByUsername(username);
            if(usersModel!= null){
                return new ResponseEntity<>("User already exists. Please choose another username",HttpStatus.OK);
            }
            return new ResponseEntity<>("Good to go",HttpStatus.OK);
        }catch (Exception e){
            StringBuilder message = new StringBuilder("Exception occurred due to: ");
            message.append(e.getMessage());
            return new ResponseEntity<>(String.valueOf(message),HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<String> checkUserInput(UsersModel userModel){
        try{
            UsersModel usersModel=userRepo.findByUsername(userModel.getUsername());
            if(usersModel!=null){
                if(userModel.getPassword().equals(usersModel.getPassword())){
                    return new ResponseEntity<>("Successfully Logged In :)",HttpStatus.OK);
                }else{
                    return new ResponseEntity<>("The Password is incorrect :(",HttpStatus.BAD_REQUEST);
                }
            }
            return new ResponseEntity<>("The User Name doesn't exist :(",HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            System.out.println("error occurred");
            StringBuilder message = new StringBuilder("Exception occurred due to: ");
            message.append(e.getMessage());
            return new ResponseEntity<>(String.valueOf(message),HttpStatus.BAD_REQUEST);
        }
    }
}
