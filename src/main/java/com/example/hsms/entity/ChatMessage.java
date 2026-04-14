package com.example.hsms.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author: ZhangWeiWei
 * @date 2025/5/9
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChatMessage implements Serializable {
    private String role;      // user/assistant
    private String content;   // 消息内容
    private LocalDateTime timestamp;
}