package com.example.hsms.entity;

import lombok.Data;

/**
 * @author: ZhangWeiWei
 * @date 2025/5/9
 */
@Data
public class ChatResponse {
    private String answer;

    public ChatResponse(String answer, boolean success) {
        this.answer = answer;
        this.success = success;
    }

    private boolean success;
}
