package org.example.reviewmakerchatgpt.service;

import lombok.RequiredArgsConstructor;
import org.example.reviewmakerchatgpt.dto.ChatGPTRequest;
import org.example.reviewmakerchatgpt.dto.ChatGPTResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class ReviewMakerService {
    @Value("${openai.model}")
    private String model;

    @Value("${openai.api.url}")
    private String apiUrl;

    private final RestTemplate template;

    public String makeReview(String request) {
        ChatGPTRequest GPTRequest = new ChatGPTRequest(model, request);
        ChatGPTResponse GPTResponse = template.postForObject(apiUrl, GPTRequest, ChatGPTResponse.class);
        return GPTResponse.getChoices().get(0).getMessage().getContent();
    }
}
