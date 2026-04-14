package com.example.hsms.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.hsms.entity.Reservation;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author: ZhangWeiWei
 * @date 2025/3/31
 */
@Mapper
public interface ReservationServiceMapper  {
    @Insert("insert into reservation(worker_id, service_time,remark,user_id,address) " +
            "values(#{workerId}, #{serviceTime},#{remark}, #{userId},#{address})")
    void insert(Reservation reservation);


//    @Select("select * from reservation where user_name=#{name}")
@Select("SELECT r.*,sw.name AS worker_name, sw.typeid FROM reservation r JOIN service_worker sw ON r.worker_id = sw.id WHERE r.user_id = #{userId} ")
    List<Reservation> select(int userId);

    @Delete("DELETE FROM reservation WHERE id = #{id}")
    void delete(int id);

    @Select("select * from reservation where id=#{id}")
    Reservation find(int id);

    @Update(" UPDATE reservation SET service_time = #{serviceTime},remark = #{remark},address = #{address} WHERE id = #{id}")
    void update(Reservation reservation);
}
