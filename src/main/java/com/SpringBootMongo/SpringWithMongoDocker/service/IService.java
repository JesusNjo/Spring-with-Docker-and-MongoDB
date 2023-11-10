package com.SpringBootMongo.SpringWithMongoDocker.service;


import com.SpringBootMongo.SpringWithMongoDocker.models.UserModel;
import com.SpringBootMongo.SpringWithMongoDocker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IService {

    @Autowired
    UserRepository userRepository;

    public List<UserModel> getAllUsers(){
        return userRepository.findAll();
    }
    public void createUsers(UserModel userModel){
        userRepository.save(userModel);
    }

    public UserModel findByIdu(Long id){

        return userRepository.findById(id).orElse(null);

    }

    public void deleteById(Long id){
        userRepository.delete(userRepository.findById(id).orElse(null));
    }

    public void modifyUser(UserModel userModel){

        userModel.setName(userModel.getName());
        userModel.setLastName(userModel.getLastName());
        userModel.setEmail(userModel.getEmail());
        userModel.setAddress(userModel.getAddress());
        userModel.setPassword(userModel.getPassword());

        userRepository.save(userModel);
    }
}
