
package com.resqai.chat;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class GeminiService {

    private final WebClient webClient;

    @Value("${gemini.api.key}")
    private String apiKey;

    @Value("${gemini.url}")
    private String geminiUrl;


    public String askGemini(String message) {

        String input = message.toLowerCase();

        if (input.contains("snake")) {
            return """
                🚨 Snake Bite First Aid

                • Keep the victim calm.
                • Do NOT suck the venom.
                • Immobilize the affected limb.
                • Remove rings or tight clothing.
                • Reach the nearest hospital immediately.
                • Call emergency services if available.
                """;
        }

        if (input.contains("burn")) {
            return """
                🔥 Burn First Aid

                • Cool the burn under running water for 20 minutes.
                • Do not apply toothpaste or oil.
                • Cover with a clean cloth.
                • Seek medical help for severe burns.
                """;
        }

        if (input.contains("heart")) {
            return """
                ❤️ Heart Attack Emergency

                • Call an ambulance immediately.
                • Keep the person seated.
                • Give aspirin if not allergic.
                • Begin CPR if the person becomes unconscious.
                """;
        }

        if (input.contains("bleeding")) {
            return """
                🩸 Heavy Bleeding

                • Apply firm pressure using a clean cloth.
                • Elevate the injured part if possible.
                • Do not remove embedded objects.
                • Seek emergency medical care.
                """;
        }

        if (input.contains("fracture") || input.contains("broken")) {
            return """
                🦴 Suspected Fracture

                • Do not move the injured limb.
                • Immobilize using a splint.
                • Apply an ice pack.
                • Visit the nearest hospital.
                """;
        }

        if (input.contains("choking")) {
            return """
                😮 Choking

                • Encourage coughing.
                • Perform abdominal thrusts (Heimlich maneuver) if necessary.
                • Call emergency services immediately.
                """;
        }

        return """
            🤖 ResQ AI

            I couldn't identify the emergency.

            Please describe:
            • What happened?
            • What symptoms are visible?
            • Is the person conscious?
            • Is there bleeding?
            """;
    }
}