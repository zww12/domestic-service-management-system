package com.example.hsms.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.hsms.entity.Reservation;
import com.example.hsms.entity.Service_Worker;
import com.example.hsms.mapper.AdminReservationMapper;
import com.example.hsms.mapper.AdminWorkerMapper;
import com.example.hsms.service.AdminReservationService;
import com.example.hsms.service.AdminWorkerService;
import org.springframework.stereotype.Service;

/**
 * @author: ZhangWeiWei
 * @date 2025/4/11
 */
@Service("AdminReservationService")
public class AdminReservationServiceimpl extends ServiceImpl<AdminReservationMapper, Reservation> implements AdminReservationService {
    @Override
    public Page<Reservation> getReservationWithWorker(Page<Reservation> page, String query) {

//            return baseMapper.selectWithWorkerInfo(page, query);
        QueryWrapper<Reservation> queryWrapper = new QueryWrapper<>();
        if (StringUtils.isNotBlank(query)) {
            // 注意：这里要指向联表后的字段别名 sw.name
            queryWrapper.like("sw.name", query);
        }
        return baseMapper.selectWithWorkerInfo(page, queryWrapper);
    }


}
