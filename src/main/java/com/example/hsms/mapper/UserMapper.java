package com.example.hsms.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.hsms.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * @author: ZhangWeiWei
 * @date 2025/3/4
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

    @Insert("insert into user(nick_name, avatar_url,openid,session_key, create_time, update_time) " +
            "values(#{nickName}, #{avatarUrl},#{openid}, #{sessionKey}, #{createTime}, #{updateTime})")
    int insert(User user);

    @Select("SELECT openid FROM user WHERE openid = #{openid}")
    User selectByOpenid(String openid);

    @Update("UPDATE user SET " +
            "nick_name = #{nickName}, " +
            "avatar_url = #{avatarUrl}, " +
//            "session_key=#{sessionKey},"+
            "update_time = #{updateTime} " +
            "WHERE openid = #{openid}")
    void update(User user);
}
