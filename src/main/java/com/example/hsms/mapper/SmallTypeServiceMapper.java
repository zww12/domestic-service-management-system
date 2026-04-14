package com.example.hsms.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.hsms.entity.Service_Worker;
import com.example.hsms.entity.Service_smalltype;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author: ZhangWeiWei
 * @date 2025/3/22
 */
@Mapper
public interface SmallTypeServiceMapper extends BaseMapper<Service_smalltype> {
    @Select("select * from Service_smalltype where bigTypeid= #{id};")
    List<Service_smalltype> find(int id);



    @Select("select * from Service_smalltype;")
    List<Service_smalltype> findall();

    List<Service_smalltype> findbyid(int id);

//    @Select("select * from Service_smalltype where id= #{id};")
//    List<Service_smalltype> findbyid(int id);
}
