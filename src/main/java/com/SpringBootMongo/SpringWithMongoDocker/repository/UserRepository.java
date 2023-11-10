package com.SpringBootMongo.SpringWithMongoDocker.repository;

import com.SpringBootMongo.SpringWithMongoDocker.models.UserModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserRepository extends MongoRepository<UserModel,Long> {


    @Query("SELECT u FROM UserModel u WHERE u.name = ?1")
    Optional<UserModel> getforName(String name);
}
