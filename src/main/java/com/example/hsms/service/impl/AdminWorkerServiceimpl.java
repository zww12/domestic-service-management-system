package com.example.hsms.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.hsms.entity.Reservation;
import com.example.hsms.entity.Service_Worker;
import com.example.hsms.mapper.*;
import com.example.hsms.service.AdminWorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @author: ZhangWeiWei
 * @date 2025/4/10
 */
@Service("AdminWorkerService")
public class AdminWorkerServiceimpl extends ServiceImpl<AdminWorkerMapper, Service_Worker> implements AdminWorkerService {
    @Autowired
    private AdminWorkerMapper adminWorkerMapper;

    @Autowired
    private AdminReservationMapper adminReservationMapper;

    @Override
    @Transactional // 添加事务注解，确保操作原子性
    public boolean removeById(Integer id) {
        // 1. 删除与该家政人员关联的预约记录
        QueryWrapper<Reservation> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("worker_id", id);
        adminReservationMapper.delete(queryWrapper);

        // 2. 删除家政人员
        return super.removeById(id);
    }

    @Override
    public List<Service_Worker> list(Map<String, Object> map) {
        return adminWorkerMapper.list(map);
    }

    @Override
    public Long getTotal(Map<String, Object> map) {
        return adminWorkerMapper.getTotal(map);
    }

    @Override
    public Service_Worker findById(int id) {
        return adminWorkerMapper.findById(id);
    }

    @Override
    public void update(Service_Worker worker) {
        adminWorkerMapper.update(worker);
    }

    @Override
    public void add(Service_Worker worker) {
        adminWorkerMapper.add(worker);
    }

}
