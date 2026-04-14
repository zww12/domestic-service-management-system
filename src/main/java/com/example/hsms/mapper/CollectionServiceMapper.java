package com.example.hsms.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.hsms.entity.Collection;
import com.example.hsms.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author: ZhangWeiWei
 * @date 2025/5/9
 */
@Mapper
public interface CollectionServiceMapper extends BaseMapper<Collection> {
    @Select("SELECT c.id, c.worker_id, sw.name AS workerName, sw.avatar_url AS workerAvatar FROM collection c LEFT JOIN service_worker sw ON c.worker_id = sw.id WHERE c.user_id = #{userId} ")
    List<Collection> findByUserId(int userId);

    //    @Results({
//            @Result(column = "collection_id", property = "id"),
//            @Result(column = "user_name", property = "userName"),
//            @Result(column = "worker_id", property = "workerId"),
//            @Result(column = "worker_name", property = "workerName"),
//            @Result(column = "worker_avatar", property = "workerAvatar")
//    })
}
