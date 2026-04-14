package com.example.hsms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.hsms.entity.Admin;

/**
 * @author: ZhangWeiWei
 * @date 2025/3/16
 */
public interface AdminService extends IService<Admin> {
    Admin login(Admin admin);
}
