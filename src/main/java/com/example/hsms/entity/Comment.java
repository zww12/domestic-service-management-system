package com.example.hsms.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author: ZhangWeiWei
 * @date 2025/3/25
 */
@Data
public class Comment {
   @TableField(value = "comment_id")
   private int commentId;
   private String content;
   @TableField(value = "worker_id")
   private int workerId;
   @TableField(value = "user_id")
   private int userId;
   @TableField(exist = false)
   private String workerName;
   @TableField(exist = false)
   private String typeid;      // 对应typeid
   @TableField(exist = false)
   private String userName;
   private int rating;

   @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
   @TableField(value = "create_time")
   private LocalDateTime createTime;

}
