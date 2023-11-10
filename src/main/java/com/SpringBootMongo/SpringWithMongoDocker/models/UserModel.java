package com.SpringBootMongo.SpringWithMongoDocker.models;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "users")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserModel {

    @Id
    private Long id;

    private String name;

    private String lastName;

    private String email;

    private String password;

    private String address;

}
