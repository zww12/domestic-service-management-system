package com.example.hsms;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@MapperScan("com.example.hsms.mapper")
@MapperScan(basePackages = "com.example.hsms.mapper")
public class HsmsApplication {
//    @Value("${wechat.appid}")
//    private String appid;

    public static void main(String[] args) {
        SpringApplication.run(HsmsApplication.class, args);
    }



}
