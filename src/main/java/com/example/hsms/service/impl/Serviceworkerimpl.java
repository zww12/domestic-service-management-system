package com.example.hsms.service.impl;

import com.example.hsms.entity.Service_Worker;
import com.example.hsms.mapper.ServiceworkerMapper;
import com.example.hsms.service.Serviceworker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author: ZhangWeiWei
 * @date 2025/3/6
 */

@Service
public class Serviceworkerimpl implements Serviceworker{
    @Autowired
    private ServiceworkerMapper serviceworkermapper;

//    @Override
//    public Serviceworker find() {
//        return null;
//    }

    @Override
    public List<Service_Worker> Serviceworkerfind() {
        List<Service_Worker> list=serviceworkermapper.find();
        return list;
    }

    @Override
    public List<Service_Worker> Serviceworkerrecommend() {
        List<Service_Worker> list=serviceworkermapper.recommend();
        return list;
    }

    @Override
    public List<Service_Worker> WorkerTypefind(int id) {
//        return null;
        List<Service_Worker> list=serviceworkermapper.findtypeid(id);
        return list;
    }

    @Override
    public Service_Worker WorkerDetail(int id) {
        Service_Worker worker=serviceworkermapper.findid(id);
        return worker;
    }

    @Override
    public List<Service_Worker> search(String s) {
        List<Service_Worker> list=serviceworkermapper.search(s);
        return list;
    }

//    @Override
//    public List<Service_Worker> list(Map<String, Object> map) {
//        return serviceworkermapper.list(map);
//    }
//
//    @Override
//    public Long getTotal(Map<String, Object> map) {
//        return serviceworkermapper.getTotal(map);
//    }



}
