package com.example.hsms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.hsms.entity.Service_Worker;
import com.example.hsms.entity.Service_smalltype;

import java.util.List;

/**
 * @author: ZhangWeiWei
 * @date 2025/3/22
 */
public interface SmallTypeService extends IService<Service_smalltype> {

    List<Service_smalltype> find(int id);

    List<Service_smalltype> findall();

    List<Service_smalltype> findbyid(int id);
}
