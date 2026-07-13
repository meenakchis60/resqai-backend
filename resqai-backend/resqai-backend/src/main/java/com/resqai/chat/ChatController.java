
package com.resqai.chat;

import lombok.RequiredArgsConstructor;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/chat")
@RequiredArgsConstructor
public class ChatController {

    private final ChatService chatService;

    @PostMapping
    public ChatResponse chat(
            @Valid @RequestBody ChatRequest request) {

        String reply =
                chatService.askGemini(request.getMessage());

        return new ChatResponse(reply);
    }
}
