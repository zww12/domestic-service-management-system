package com.example.hsms.controller;

import com.alibaba.druid.util.StringUtils;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.example.hsms.constant.SystemConstant;
import com.example.hsms.entity.Admin;
import com.example.hsms.entity.R;
import com.example.hsms.entity.User;
import com.example.hsms.service.AdminService;
import com.example.hsms.util.JwtUtils;
import com.example.hsms.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: ZhangWeiWei
 * @date 2025/3/16
 */
@RestController
@RequestMapping("/back")
public class AdminServiceController {
    @Autowired
    private AdminService adminservice;

    @PostMapping("login")
    public R login(@RequestBody Admin admin){
//        Admin user=adminservice.login(admin);
        try {
            Admin user=adminservice.login(admin);
//            String token = JwtUtils.generateToken(user.getId().toString());
            String token = JwtUtils.createJWT("-1", "admin", SystemConstant.JWT_TTL);
            Map<String,Object> resultMap=new HashMap<>();
            resultMap.put("token",token);
            resultMap.put("username",user.getUsername());
            resultMap.put("password",user.getPassword());
            return R.ok(resultMap);


//            return R.success(200,"success").put("username",user.getUsername());
        } catch (Exception e) {
            return R.error(500, e.getMessage());
        }
//        Admin user=adminservice.login(admin);
//        if(user==null){
//            return R.error();
//        }
//        if(user.getUsername().isEmpty()){
//            return R.error("用户名不能为空！");
//        }
//        if(user.getPassword().isEmpty()){
//            return R.error("密码不能为空");
//        }
//        if(!user.getPassword().equals(admin.getPassword())){
//            return R.error("密码错误");
//        }
//        return R.success(200,"success");

    }
    @PostMapping("/admin/modifyPassword")
    public R modifyPassword(@RequestBody Admin admin){
//        if(StringUtil.isEmpty(admin.getUsername())){
//            return R.error("用户名不能为空");
//        }
//        if(StringUtil.isEmpty(admin.getPassword())){
//            return R.error("新密码不能为空");
//        }
//        adminservice.update(new UpdateWrapper<Admin>().set("password",admin.getNewpassword()).eq("username",admin.getUsername()));
//        return R.ok();
        if (StringUtil.isEmpty(admin.getUsername())) {
            return R.error("用户名不能为空");
        }
        if (StringUtil.isEmpty(admin.getNewPassword())) { // 检查新密码
            return R.error("新密码不能为空");
        }
        // 使用 newPassword 更新数据库的 password 列
        adminservice.update(
                new UpdateWrapper<Admin>()
                        .set("password", admin.getNewPassword())
                        .eq("username", admin.getUsername())
        );
        return R.ok();
    }

}
