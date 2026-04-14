package com.example.hsms.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.hsms.entity.*;
import com.example.hsms.service.AdminCommentService;
import com.example.hsms.service.AdminWorkerService;
import com.example.hsms.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: ZhangWeiWei
 * @date 2025/4/13
 */
@RestController
@RequestMapping("/admin/comment")
public class AdminCommentController {
    @Autowired
    private AdminCommentService adminCommentService;

    @Autowired
    private AdminWorkerService adminWorkerService;

    @RequestMapping("/list")
    public R listbyuser(@RequestBody PageBean pageBean) {
//        String username = pageBean.getUsername();
//        Service_Worker worker = adminWorkerService.getOne(
//                new QueryWrapper<Service_Worker>().eq("username", username)
//        );
//
//        String workerName = worker.getName();
//        // 3. 构建分页和查询条件
//        Page<Comment> page = new Page<>(pageBean.getPageNum(), pageBean.getPageSize());
//        QueryWrapper<Comment> queryWrapper = new QueryWrapper<>();
//
//        // 必须条件：只查询当前家政人员的订单
//        queryWrapper.eq("worker_name", workerName); // 假设预约表中家政人员姓名字段为staff_name
//
//        // 可选：根据用户名称筛选（原逻辑）
//        String query = (pageBean.getQuery() != null) ? pageBean.getQuery().trim() : "";
//        if (StringUtil.isNotEmpty(query)) {
//            queryWrapper.like("user_name", query);
//        }
//        String query = (pageBean.getQuery() != null) ? pageBean.getQuery().trim() : "";
//
//        Page<Comment> page = new Page<>(pageBean.getPageNum(), pageBean.getPageSize());
//        QueryWrapper<Comment> queryWrapper = new QueryWrapper<>();
//
//        if (StringUtil.isNotEmpty(query)) {
//            queryWrapper.like("worker_name", query);
//        }
//        queryWrapper.isNotNull("worker_name"); // 可选：排除 nick_name 为 null 的记录
//
//
//        // 4. 执行分页查询
//        Page<Comment> pageResult = adminCommentService.page(page, queryWrapper);
//
//        // 返回结果
//        Map<String, Object> map = new HashMap<>();
//        map.put("list", pageResult.getRecords());
//        map.put("total", pageResult.getTotal());
//        return R.ok(map);
        String query = (pageBean.getQuery() != null) ? pageBean.getQuery().trim() : "";
        Page<Comment> pageParam = new Page<>(pageBean.getPageNum(), pageBean.getPageSize());

        Page<Comment> pageResult = adminCommentService.getCommentWithWorker(pageParam, query);
        Map<String, Object> map = new HashMap<>();
        map.put("list", pageResult.getRecords());
        map.put("total", pageResult.getTotal());
        return R.ok(map);
    }
}
