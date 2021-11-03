package com.richieoscar.chatty.service;

import com.richieoscar.chatty.storage.UserStorageService;
import org.springframework.stereotype.Service;

@Service
public class UserRegistrationService implements Register {


    @Override
    public void registerUser(String user) throws Exception {
        UserStorageService.getInstance().addUSer(user);
    }
}
