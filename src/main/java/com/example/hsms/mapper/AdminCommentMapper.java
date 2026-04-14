package com.example.hsms.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.hsms.entity.Comment;
import com.example.hsms.entity.Reservation;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author: ZhangWeiWei
 * @date 2025/4/13
 */
@Mapper
public interface AdminCommentMapper extends BaseMapper<Comment> {

//    Page<Reservation> selectWithWorkerInfo(@Param("page") Page<Reservation> page,
//                                           @Param(Constants.WRAPPER) QueryWrapper<Reservation> queryWrapper);

    @Select("SELECT r.*,sw.name AS workerName,sw.typeid, u.nick_name AS userName FROM comment r LEFT JOIN service_worker sw ON r.worker_id = sw.id LEFT JOIN user u ON r.user_id = u.id ${ew.customSqlSegment} ")
    Page<Comment> selectWithWorkerInfo( @Param("page") Page<Comment> page, @Param(Constants.WRAPPER) QueryWrapper<Comment> queryWrapper);
}
