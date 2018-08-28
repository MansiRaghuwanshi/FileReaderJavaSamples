package com.tech.practice.snippets;

import java.util.ArrayList;
import java.util.List;

public class StubUser implements StubUserInterface {

    public StubUser(String name){

    }

    public StubUser(){

    }
    @Override
    public List<User> createUsers(){
        User  u1 = new User();
        u1.setfName("user1");
        User u2 = new User();
        u2.setfName("user2");

        List<User> userList = new ArrayList<>();
        return userList;
    }
}
