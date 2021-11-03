package com.richieoscar.chatty.controller;

import com.richieoscar.chatty.model.Message;
import com.richieoscar.chatty.storage.UserStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class MessageController {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;



    @MessageMapping("/message{user}")
    private void  sendMessage(String user, Message message){
        boolean userExists = UserStorageService.getInstance().getUsers().contains(user);
        if(userExists){
            System.out.println("Message sent to " +user +message);
            messagingTemplate.convertAndSend("/topic/messages/" +user, message);
        }
        else {
            throw new IllegalStateException("User does not exist");
        }


    }
}
