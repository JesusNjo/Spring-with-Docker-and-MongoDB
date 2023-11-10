package com.SpringBootMongo.SpringWithMongoDocker.controller;


import com.SpringBootMongo.SpringWithMongoDocker.models.UserModel;
import com.SpringBootMongo.SpringWithMongoDocker.models.dto.UserDTO;
import com.SpringBootMongo.SpringWithMongoDocker.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class PrincipalController {


    @Autowired
    IService iService;

    @PostMapping
    public ResponseEntity<UserModel> createUser(@RequestBody UserDTO userDTO){
        double ran = (Math.random()*10)+1;

        UserModel userModel = UserModel.builder()
                .name(userDTO.getName())
                .lastName(userDTO.getLastName())
                .email(userDTO.getEmail())
                .address(userDTO.getAddress())
                .password(userDTO.getPassword())
                .id((long) ran)
                .build();

        iService.createUsers(userModel);

        return ResponseEntity.ok(userModel);
    }

    @GetMapping
    public ResponseEntity<List<UserModel>> getAllUsers(){
        return ResponseEntity.ok(iService.getAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserModel> getById(@PathVariable Long id){
        return ResponseEntity.ok(iService.findByIdu(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        iService.deleteById(id);
        return ResponseEntity.ok(UserModel.class.getName());
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> modifyUser(@PathVariable Long id, @RequestBody UserModel userModel){


        iService.modifyUser(userModel);

        return ResponseEntity.ok(UserModel.class.getName());
    }
}
