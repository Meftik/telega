package com.netcracker.telega;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserRepository  extends MongoRepository<User, String>{
    @Autowired
 // private  MongoTemplate mongoTemplate ; ругается
    public User findByFirstName(String firstName);
    public List<User> findByLastName(String lastName);

}
