package com.richieoscar.chatty.storage;

import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

public class UserStorageService implements Storage{
    private static UserStorageService INSTANCE;
    Set<String> users;

    private UserStorageService() {
        users = new HashSet<>();
    }

    public static synchronized   UserStorageService getInstance(){
        if(INSTANCE == null){
            INSTANCE = new UserStorageService();
        }
        return INSTANCE;
    }


    @Override
    public void addUSer(String user) throws Exception {
        if(users.contains(user)){
            throw new IllegalStateException("User already exist");
        }
        users.add(user);

    }

    public Set<String> getUsers(){
        return users;
    }

    @Override
    public void deleteUser(String user) {
        if(user.contains(user)){
            users.remove(user);
        }
    }


}
