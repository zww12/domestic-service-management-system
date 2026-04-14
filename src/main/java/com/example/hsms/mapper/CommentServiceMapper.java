package com.example.hsms.mapper;

import com.example.hsms.entity.Comment;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author: ZhangWeiWei
 * @date 2025/3/25
 */
@Mapper
public interface CommentServiceMapper {
    @Select("select c.*,u.nick_name AS userName from comment c JOIN user u ON c.user_id=u.id where worker_id=#{id}")
    List<Comment> find(int id);

    @Insert("insert into comment(content,worker_id,user_id,rating,create_time) values(#{content}, #{workerId}, #{userId}, #{rating},#{createTime})")
    void insert(Comment comment);

//    @Select("select * from comment where user_name=#{name}")
@Select("SELECT c.*, sw.name AS worker_name, sw.typeid FROM comment c JOIN service_worker sw ON c.worker_id = sw.id WHERE c.user_id = #{userId} ")
    List<Comment> findall(int userId);

    @Delete("delete from comment where comment_id=#{id}")
    void delete(int id);
}
