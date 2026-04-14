package com.example.hsms.mapper;

import com.example.hsms.entity.BigType;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author: ZhangWeiWei
 * @date 2025/3/11
 */
@Mapper
public interface BigTypeServiceMapper {
    @Select("Select * from service_category")
    List<BigType> findall();
}
