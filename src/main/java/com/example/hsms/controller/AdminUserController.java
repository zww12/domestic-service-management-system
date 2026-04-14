package com.example.hsms.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.hsms.entity.PageBean;
import com.example.hsms.entity.R;
import com.example.hsms.entity.User;
import com.example.hsms.service.AdminUserService;
import com.example.hsms.service.UserService;
import com.example.hsms.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: ZhangWeiWei
 * @date 2025/4/9
 */
@RestController
@RequestMapping("/admin/user")
public class AdminUserController {

    @Autowired
    private AdminUserService adminUserService;

    /**
     * 根据条件分页查询用户信息
     * @param pageBean
     * @return
     */
//    @RequestMapping("/list")
//    public R list(@RequestBody PageBean pageBean){
//        System.out.println(pageBean);
//        String query=pageBean.getQuery().trim();
//        Page<User> page=new Page<>(pageBean.getPageNum(),pageBean.getPageSize());
//        Page<User> pageResult = adminUserService.page(page, new QueryWrapper<User>().like(StringUtil.isNotEmpty(query), "nick_name", query));
//        Map<String,Object> map=new HashMap<>();
//        map.put("userList",pageResult.getRecords());
//        map.put("total",pageResult.getTotal());
//        return R.ok(map);
//    }
    @RequestMapping("/list")
    public R list(@RequestBody PageBean pageBean) {
        String query = (pageBean.getQuery() != null) ? pageBean.getQuery().trim() : "";

        Page<User> page = new Page<>(pageBean.getPageNum(), pageBean.getPageSize());
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();

        if (StringUtil.isNotEmpty(query)) {
            queryWrapper.like("nick_name", query);
        }
        queryWrapper.isNotNull("nick_name"); // 可选：排除 nick_name 为 null 的记录

        Page<User> pageResult = adminUserService.page(page, queryWrapper);

        Map<String, Object> map = new HashMap<>();
        map.put("userList", pageResult.getRecords());
        map.put("total", pageResult.getTotal());
        return R.ok(map);
    }

}
