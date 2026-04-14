package com.example.hsms.controller;

import com.example.hsms.entity.ChatRequest;
import com.example.hsms.entity.ChatResponse;
import com.example.hsms.util.FaqReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.*;

/**
 * @author: ZhangWeiWei
 * @date 2025/5/9
 */
@RestController
@RequestMapping("/api/chat")
public class ChatController {

    @Value("${deepseek.api.url}")
    private String apiUrl;

    @Value("${deepseek.api.key}")
    private String apiKey;

    @Value("${deepseek.api.model}")
    private String model;
    @PostMapping("/ask")
    public ChatResponse askQuestion(@RequestBody ChatRequest request) {
        String faqContent = FaqReader.readFaq();
        // 构建提示语
        String prompt = new StringBuilder()
                .append("你是一个家政服务助手：\n")
                .append(faqContent)
                .append("\n\n用户问题：")
                .append(request.getQuestion())
                .toString();
        // 配置请求头
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(apiKey);
        // 构建请求体
        Map<String, Object> body = new HashMap<>();
        body.put("model", model);
        List<Map<String,String>> messages = new ArrayList<>();
        Map<String, String> message = new HashMap<>();
        message.put("role", "user");
        message.put("content", prompt);

        messages.add(message);
        body.put("messages", messages);
        body.put("temperature", 0.7);
        body.put("max_tokens", 2000);
        // 发送请求
        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(body, headers);
        RestTemplate restTemplate = new RestTemplate();
        Map<String, Object> response = restTemplate.postForObject(apiUrl, entity, Map.class);
        return extractAnswer(response);
    }


    private ChatResponse extractAnswer(Map<String, Object> response) {
        try {
            // 实际解析逻辑
            Map<String, Object> firstChoice = ((List<Map<String, Object>>) response.get("choices")).get(0);
            Map<String, Object> message = (Map<String, Object>) firstChoice.get("message");
            String answer = (String) message.get("content");
//            chatHistoryService.saveMessage(userId, "assistant", answer.trim());
            return new ChatResponse(answer.trim(), true);
        } catch (Exception e) {
            return new ChatResponse("系统繁忙，请稍后再试", false);
        }
    }
}