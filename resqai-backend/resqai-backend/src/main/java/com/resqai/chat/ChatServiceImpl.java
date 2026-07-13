
package com.resqai.chat;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChatServiceImpl implements ChatService {

    private final GeminiService geminiService;

    @Override
    public String askGemini(String message) {

        return geminiService.askGemini(message);

    }
}