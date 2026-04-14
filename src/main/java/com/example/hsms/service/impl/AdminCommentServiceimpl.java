package com.example.hsms.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.hsms.entity.Comment;
import com.example.hsms.entity.Reservation;
import com.example.hsms.mapper.AdminCommentMapper;
import com.example.hsms.mapper.AdminReservationMapper;
import com.example.hsms.service.AdminCommentService;
import com.example.hsms.service.AdminReservationService;
import org.springframework.stereotype.Service;

/**
 * @author: ZhangWeiWei
 * @date 2025/4/13
 */
@Service("AdminCommentService")
public class AdminCommentServiceimpl extends ServiceImpl<AdminCommentMapper, Comment> implements AdminCommentService {
    @Override
    public Page<Comment> getCommentWithWorker(Page<Comment> page, String query) {
        QueryWrapper<Comment> queryWrapper = new QueryWrapper<>();
        if (StringUtils.isNotBlank(query)) {
            // 注意：这里要指向联表后的字段别名 sw.name
            queryWrapper.like("sw.name", query);  // 关键修改点！
        }
        return baseMapper.selectWithWorkerInfo(page, queryWrapper);
    }
}
