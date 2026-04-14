package com.example.hsms.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author: ZhangWeiWei
 * @date 2025/3/31
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reservation {
    private int id;
    @TableField(value = "worker_id")
    private int workerId;

    @TableField(value = "user_id")
    private int userId;
//    private LocalDateTime service_time;
@TableField(value = "service_time")
@JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
private String serviceTime; // 类型保持为 String
    private String remark;
    @TableField(exist = false)
    private String userName;
//    @TableField(value = "worker_name")
//    private String workerName;
@TableField(exist = false)
    private String workerName;  // 对应worker_name
    @TableField(exist = false)
    private String typeid;      // 对应typeid
    private String address;
    private int status;

}
