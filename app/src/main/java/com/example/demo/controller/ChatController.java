package com.example.demo.controller;

import com.example.demo.model.ChatMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ChatController {
    @MessageMapping ("/sendMessage")     //endpoints is a method sendMessage like requestor
    @SendTo("/topic/messages")    //websocket message to destination of both the side
    public ChatMessage sendMessage(ChatMessage message){
        return message;
    }
    @GetMapping
    public String chat(){
        return  "chat";
    }

}
