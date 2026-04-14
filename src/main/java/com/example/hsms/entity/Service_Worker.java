package com.example.hsms.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author: ZhangWeiWei
 * @date 2025/3/5
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("service_worker")
public class Service_Worker {
    private Integer id;
    private String name;
    private int gender;
    private int age;
    private String phone;
    @TableField(value = "avatar_url")
    private String avatarUrl="default.jpg";

    @TableField(value = "is_swiper")
    private boolean isSwiper=false;

    private int typeid;

    @TableField(value = "swiper_sort")
    private int swiperSort;
    private String swiperurl="default.jpg";
    private String description;

//    private String username;
//    private String password;

    @TableField(select = false)
    private Service_smalltype type; // 商品类别




}
