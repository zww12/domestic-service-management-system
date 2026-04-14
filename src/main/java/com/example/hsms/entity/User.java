package com.example.hsms.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author: ZhangWeiWei
 * @date 2025/3/4
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private  int id;
    private String openid;
    @TableField(value = "nick_name")  // 明确映射到数据库列 nick_name
    private String nickName;         // 使用驼峰命名

    @TableField(value = "avatar_url")
    private String avatarUrl;

    @TableField(select = false,value = "session_key")
    private String sessionKey;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @TableField(value = "create_time")
    private LocalDateTime createTime;

    @TableField(value = "update_time")
    private LocalDateTime updateTime;


}
