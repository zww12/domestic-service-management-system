package com.example.hsms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.hsms.entity.R;
import com.example.hsms.entity.Reservation;
import com.example.hsms.entity.User;

import java.util.List;

/**
 * @author: ZhangWeiWei
 * @date 2025/3/31
 */
public interface ReservationService  {
    R add(Reservation reservation);

    List<Reservation> select(int userId);

    Reservation find(int id);

    R update(Reservation reservation);

    R delete(int id);
}
