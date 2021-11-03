package com.richieoscar.chatty.controller;

import com.richieoscar.chatty.model.Greeting;
import com.richieoscar.chatty.model.Message;
import com.richieoscar.chatty.model.UserResponse;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

    @RequestMapping("/home")
    public String home(){
        return "index";
    }

    @RequestMapping("/userLogin")
    public String loginWithUser(){
        return "login";
    }

    @MessageMapping("/login")
    @SendTo("/topic/messages")
    private Greeting greetUser(Message message){
        return new Greeting(message.getUserName(), message.getContent());
    }


}
