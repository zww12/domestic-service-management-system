package com.example.hsms.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: ZhangWeiWei
 * @date 2025/5/9
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("collection")
public class Collection {
    private int id;
    @TableField(exist = false)
    private String userName;
    @TableField(value = "worker_id")
    private int workerId;
    @TableField(value = "user_id")
    private int userId;

    @TableField(exist = false) // 表示非数据库字段
    private String workerName;

    @TableField(exist = false)
    private String workerAvatar;
}
