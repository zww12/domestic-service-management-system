package com.example.hsms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.hsms.entity.Admin;
import com.example.hsms.entity.User;
import com.example.hsms.mapper.AdminServiceMapper;
import com.example.hsms.mapper.AdminUserMapper;
import com.example.hsms.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: ZhangWeiWei
 * @date 2025/3/16
 */
@Service("AdminService")
public class AdminServiceimpl extends ServiceImpl<AdminServiceMapper, Admin> implements AdminService {
    @Autowired
    private AdminServiceMapper adminservicemapper;
    @Override
    public Admin login(Admin admin) {
        if(admin.getUsername().isEmpty()) {
            throw new RuntimeException("用户名不能为空");
        }
        if(admin.getPassword().isEmpty()){
            throw new RuntimeException("密码不能为空");
        }
        Admin user=adminservicemapper.select(admin.getUsername());
        if(user==null){
            throw new RuntimeException("用户不存在");

        }

        if (!user.getPassword().equals(admin.getPassword())) {
            throw new RuntimeException("密码错误");
        }

        return user;

    }
}
