package com.example.onlinepharmacy.controller;

import com.example.onlinepharmacy.service.ChatService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/chat")
public class ChatController {

    private final ChatService chatService;

    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    @PostMapping
    public String chat(@RequestBody String question) {
        return chatService.ask(question);
    }

    @GetMapping("/history")
    public java.util.List<String> history() {
        return chatService.getHistory();
    }
}
