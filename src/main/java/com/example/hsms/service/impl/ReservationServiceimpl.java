package com.example.hsms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.hsms.entity.R;
import com.example.hsms.entity.Reservation;
import com.example.hsms.mapper.ReservationServiceMapper;
import com.example.hsms.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author: ZhangWeiWei
 * @date 2025/3/31
 */
@Service
public class ReservationServiceimpl  implements ReservationService{

    @Autowired
    private ReservationServiceMapper reservationServiceMapper;

    @Override
    @Transactional // 添加事务管理
    public R add(Reservation reservation) {
        try {
            reservationServiceMapper.insert(reservation);
            return R.ok("预约成功");
        } catch (Exception e) {
            // 记录日志
            return R.error("预约失败: " + e.getMessage());
        }
    }

    @Override
    public List<Reservation> select(int userId) {
        List<Reservation> list=  reservationServiceMapper.select(userId);
        return list;
    }

    @Override
    public Reservation find(int id) {
        Reservation reservation=reservationServiceMapper.find(id);
        return reservation;
    }

    @Override
    public R update(Reservation reservation) {
        try {
            reservationServiceMapper.update(reservation);
            return R.ok("修改成功");
        } catch (Exception e) {
            // 记录日志
            return R.error("修改失败: " + e.getMessage());
        }
    }

    @Override
    public R delete(int id) {
        try {
            reservationServiceMapper.delete(id);
            return R.ok("取消成功");
        } catch (Exception e) {
            // 记录日志
            return R.error("取消失败: " + e.getMessage());
        }
    }
}
