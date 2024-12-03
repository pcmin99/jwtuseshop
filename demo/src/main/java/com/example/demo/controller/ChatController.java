package com.example.demo.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.example.demo.entity.ChatMessage;

@Controller
public class ChatController {

    // @MessageMapping("/user/chat")
    // @SendTo("/topic/messages")
    // public ChatMessage sendMessage(ChatMessage message) {
    //     message.setTimestamp(String.valueOf(System.currentTimeMillis()));
    //     return message;
    // }
}
