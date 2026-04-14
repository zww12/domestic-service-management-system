package com.example.hsms.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.hsms.entity.Comment;
import com.example.hsms.entity.Reservation;

/**
 * @author: ZhangWeiWei
 * @date 2025/4/13
 */
public interface AdminCommentService extends IService<Comment> {
    Page<Comment> getCommentWithWorker(Page<Comment> page, String query);
}
