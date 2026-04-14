package com.example.hsms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.hsms.entity.LoginDao;
import com.example.hsms.entity.Reservation;
import com.example.hsms.entity.User;

/**
 * @author: ZhangWeiWei
 * @date 2025/3/4
 */
public interface UserService  extends IService<User> {

    /**
     * 新增用户
     * @param user
     */
    void add(User user);

    /**
     * 微信登录/注册
     * @param logindao 登录参数
     * @return 用户信息
     */
    User wxLogin(LoginDao logindao);

}
