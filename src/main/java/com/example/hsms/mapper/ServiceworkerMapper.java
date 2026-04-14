package com.example.hsms.mapper;

import com.example.hsms.entity.Service_Worker;
import com.example.hsms.service.Serviceworker;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * @author: ZhangWeiWei
 * @date 2025/3/6
 */
@Mapper
public interface ServiceworkerMapper {

    @Select("SELECT * FROM service_worker WHERE is_swiper = 1 ORDER BY swiper_sort ASC; ")
    List<Service_Worker> find();

    @Select("Select * from service_worker;")
    List<Service_Worker> recommend();

    @Select("select * from service_worker where typeid=#{id}")
    List<Service_Worker> findtypeid(int id);
    @Select("select * from service_worker where id=#{id}")
    Service_Worker findid(int id);

    @Select("select * from service_worker where name like CONCAT('%', #{s}, '%')")
    List<Service_Worker> search(String s);

//    List<Service_Worker> list(Map<String, Object> map);
//
//    Long getTotal(Map<String, Object> map);
}
