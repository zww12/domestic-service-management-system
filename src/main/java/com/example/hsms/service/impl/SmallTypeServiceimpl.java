package com.example.hsms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.hsms.entity.Service_Worker;
import com.example.hsms.entity.Service_smalltype;
import com.example.hsms.mapper.AdminWorkerMapper;
import com.example.hsms.mapper.SmallTypeServiceMapper;
import com.example.hsms.service.SmallTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: ZhangWeiWei
 * @date 2025/3/22
 */
@Service("SmallTypeService")
public class SmallTypeServiceimpl extends ServiceImpl<SmallTypeServiceMapper, Service_smalltype> implements SmallTypeService {
    @Autowired
    private SmallTypeServiceMapper smalltyeservicemapper;
    @Override
    public List<Service_smalltype> find(int id) {
        List<Service_smalltype> list=smalltyeservicemapper.find(id);
        return list;

    }

    @Override
    public List<Service_smalltype> findall() {
        List<Service_smalltype> list=smalltyeservicemapper.findall();
        return list;
    }

    @Override
    public List<Service_smalltype> findbyid(int id) {
        List<Service_smalltype> list=smalltyeservicemapper.findbyid(id);
        return list;
    }

//    @Override
//    public List<Service_smalltype> findById(int id) {
//        List<Service_smalltype> list=smalltyeservicemapper.findbyid(id);
//        return list;
//    }
}
