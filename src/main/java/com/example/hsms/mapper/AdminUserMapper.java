package com.example.hsms.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.hsms.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author: ZhangWeiWei
 * @date 2025/4/9
 */
@Mapper
public interface AdminUserMapper extends BaseMapper<User> {
}
