package com.example.hsms.service;

import com.example.hsms.entity.Service_Worker;

import java.util.List;
import java.util.Map;

/**
 * @author: ZhangWeiWei
 * @date 2025/3/6
 */
public interface Serviceworker {

    /**
     * 查询家政轮播图
     * @param
     */

//    Serviceworker find();


    List<Service_Worker> Serviceworkerfind();

    List<Service_Worker> Serviceworkerrecommend();

    List<Service_Worker> WorkerTypefind(int id);

    Service_Worker WorkerDetail(int id);

    List<Service_Worker> search(String s);

//    List<Service_Worker> list(Map<String,Object> map);
//
//    Long getTotal(Map<String,Object> map);
}
