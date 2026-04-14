package com.example.hsms.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.hsms.entity.Reservation;
import com.example.hsms.entity.User;

/**
 * @author: ZhangWeiWei
 * @date 2025/4/11
 */
public interface AdminReservationService extends IService<Reservation> {
    Page<Reservation> getReservationWithWorker(Page<Reservation> page, String query);
}
