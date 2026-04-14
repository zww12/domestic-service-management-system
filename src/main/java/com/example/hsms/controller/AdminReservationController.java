package com.example.hsms.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.hsms.entity.*;
import com.example.hsms.service.AdminReservationService;
import com.example.hsms.service.AdminUserService;
import com.example.hsms.service.AdminWorkerService;
import com.example.hsms.service.ReservationService;
import com.example.hsms.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: ZhangWeiWei
 * @date 2025/4/11
 */

@RestController
@RequestMapping("/admin/order")
public class AdminReservationController {
    @Autowired
    private AdminReservationService adminReservationService;
    @Autowired
    private AdminWorkerService adminWorkerService;

    /**
     * 根据条件分页查询预约信息
     * @param pageBean
     * @return
     */

    @RequestMapping("/list")
    public R list(@RequestBody PageBean pageBean) {
//        String query = (pageBean.getQuery() != null) ? pageBean.getQuery().trim() : "";
//
//        Page<Reservation> page = new Page<>(pageBean.getPageNum(), pageBean.getPageSize());
//        QueryWrapper<Reservation> queryWrapper = new QueryWrapper<>();
//
//        if (StringUtil.isNotEmpty(query)) {
//            queryWrapper.like("worker_name", query);
//        }
//        queryWrapper.isNotNull("worker_name"); // 可选：排除 nick_name 为 null 的记录
//
//        Page<Reservation> pageResult = adminReservationService.page(page, queryWrapper);
//
//        Map<String, Object> map = new HashMap<>();
//        map.put("List", pageResult.getRecords());
//        map.put("total", pageResult.getTotal());
//        return R.ok(map);
       /* String query = (pageBean.getQuery() != null) ? pageBean.getQuery().trim() : "";

        // 创建自定义的分页对象（页码从1开始）
        Page<Reservation> pageParam = new Page<>(pageBean.getPageNum(), pageBean.getPageSize());

        // 使用自定义的联表查询方法
        Page<Reservation> pageResult = adminReservationService.getReservationWithWorker(
                pageParam,
                query // 传递搜索参数
        );

        Map<String, Object> map = new HashMap<>();
        map.put("list", pageResult.getRecords());
        map.put("total", pageResult.getTotal());
        return R.ok(map);*/
        String query = (pageBean.getQuery() != null) ? pageBean.getQuery().trim() : "";
        Page<Reservation> pageParam = new Page<>(pageBean.getPageNum(), pageBean.getPageSize());

        Page<Reservation> pageResult = adminReservationService.getReservationWithWorker(
                pageParam,
                query
        );
        Map<String, Object> map = new HashMap<>();
        map.put("list", pageResult.getRecords());
        map.put("total", pageResult.getTotal());
        return R.ok(map);

//        return R.ok()
//                .put("list", pageResult.getRecords())
//                .put("total", pageResult.getTotal());
    }
    @RequestMapping("/listbyuser")
    public R listbyuser(@RequestBody PageBean pageBean) {
        String username = pageBean.getUsername();
        Service_Worker worker = adminWorkerService.getOne(
                new QueryWrapper<Service_Worker>().eq("username", username)
        );

        String workerName = worker.getName();
        // 3. 构建分页和查询条件
        Page<Reservation> page = new Page<>(pageBean.getPageNum(), pageBean.getPageSize());
        QueryWrapper<Reservation> queryWrapper = new QueryWrapper<>();

        // 必须条件：只查询当前家政人员的订单
        queryWrapper.eq("worker_name", workerName);

        // 可选：根据用户名称筛选（原逻辑）
        String query = (pageBean.getQuery() != null) ? pageBean.getQuery().trim() : "";
        if (StringUtil.isNotEmpty(query)) {
            queryWrapper.like("user_name", query);
        }

        // 4. 执行分页查询
        Page<Reservation> pageResult = adminReservationService.page(page, queryWrapper);

        // 返回结果
        Map<String, Object> map = new HashMap<>();
        map.put("list", pageResult.getRecords());
        map.put("total", pageResult.getTotal());
        return R.ok(map);
    }
    // 确认预约
    @PostMapping("/confirm/{id}")
    public R confirm(@PathVariable Integer id) {
        Reservation reservation = adminReservationService.getById(id);
        if (reservation == null) {
            return R.error("预约不存在");
        }
        if (reservation.getStatus() != 0) {
            return R.error("当前状态不可操作");
        }
        reservation.setStatus(1); // 设置为已确认
        adminReservationService.updateById(reservation);
        return R.ok();
    }

    // 拒绝预约
    @PostMapping("/reject/{id}")
    public R reject(@PathVariable Integer id) {
        Reservation reservation = adminReservationService.getById(id);
        if (reservation == null) {
            return R.error("预约不存在");
        }
        if (reservation.getStatus() != 0) {
            return R.error("当前状态不可操作");
        }

        reservation.setStatus(4); // 设置为已取消
        adminReservationService.updateById(reservation);
        return R.ok();
    }
    // 完成预约接口
    @PostMapping("/complete/{id}")
    public R complete(@PathVariable Integer id) {
        Reservation reservation = adminReservationService.getById(id);
        if (reservation == null) {
            return R.error("预约不存在");
        }
        if (reservation.getStatus() != 1) {
            return R.error("当前状态不可操作");
        }

        reservation.setStatus(3); // 设置为已完成
        adminReservationService.updateById(reservation);
        return R.ok();
    }

}
