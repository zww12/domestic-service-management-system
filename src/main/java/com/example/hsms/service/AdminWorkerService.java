package com.example.hsms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.hsms.entity.Service_Worker;
import com.example.hsms.entity.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @author: ZhangWeiWei
 * @date 2025/4/10
 */
public interface AdminWorkerService extends IService<Service_Worker> {
    @Transactional // 添加事务注解，确保操作原子性
    abstract boolean removeById(Integer id);

    List<Service_Worker> list(Map<String,Object> map);

    Long getTotal(Map<String,Object> map);

    Service_Worker findById(int id);

    void update(Service_Worker worker);

    void add(Service_Worker worker);
}
