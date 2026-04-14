package com.example.hsms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.hsms.entity.User;
import com.example.hsms.mapper.AdminUserMapper;
import com.example.hsms.service.AdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: ZhangWeiWei
 * @date 2025/4/9
 */
@Service("AdminUserService")
public class AdminUserServiceimpl extends ServiceImpl<AdminUserMapper, User> implements AdminUserService {
    @Autowired
   private AdminUserMapper adminUserMapper;
}
