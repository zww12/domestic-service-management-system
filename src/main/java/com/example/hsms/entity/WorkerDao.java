package com.example.hsms.entity;

import lombok.Data;

/**
 * @author: ZhangWeiWei
 * @date 2025/4/12
 */
@Data
public class WorkerDao{
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private String username;
    private String password;
    // 如果有其他字段（如type），也需添加
}