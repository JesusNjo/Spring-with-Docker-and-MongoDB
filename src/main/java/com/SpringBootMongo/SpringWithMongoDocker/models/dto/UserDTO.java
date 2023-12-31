package com.SpringBootMongo.SpringWithMongoDocker.models.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private String name;

    private String lastName;

    private String email;

    private String password;

    private String address;
}
