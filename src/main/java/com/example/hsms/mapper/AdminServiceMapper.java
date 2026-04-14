package com.example.hsms.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.hsms.entity.Admin;
import com.example.hsms.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author: ZhangWeiWei
 * @date 2025/3/16
 */
@Mapper
public interface AdminServiceMapper extends BaseMapper<Admin> {
    @Select("SELECT * FROM admin WHERE BINARY username = #{username}")
    Admin select(String username);
}
