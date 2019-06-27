package com.netcracker.telega;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
@Document
public class Friends {
    @Id
    public String id;
    public String username;
    public String friends;

    public Friends(String username, String friends) {
        this.username = username;
        this.friends = friends;
    }

    public String getUsername() {
        return username;
    }

    public String getFriends() {
        return friends;
    }

    public Friends() {
    }
}
