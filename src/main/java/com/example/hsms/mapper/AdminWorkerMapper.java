package com.example.hsms.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.hsms.entity.Service_Worker;
import com.example.hsms.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @author: ZhangWeiWei
 * @date 2025/4/10
 */
@Mapper
public interface AdminWorkerMapper extends BaseMapper<Service_Worker> {
    List<Service_Worker> list(Map<String, Object> map);

    Long getTotal(Map<String, Object> map);
    Service_Worker findById(int id);

    void update(Service_Worker worker);

    void add(Service_Worker worker);
}
