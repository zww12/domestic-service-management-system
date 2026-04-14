package com.example.hsms.service.impl;

import com.example.hsms.entity.Comment;
import com.example.hsms.entity.R;
import com.example.hsms.mapper.CommentServiceMapper;
import com.example.hsms.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author: ZhangWeiWei
 * @date 2025/3/25
 */
@Service
public class CommentServiceimpl implements CommentService {
    @Autowired
    private CommentServiceMapper commentServiceMapper;
    @Override
    public List<Comment> WorkerComment(int id) {
        List<Comment> list=commentServiceMapper.find(id);
        return list;

    }

    @Override
    public R add(Comment comment) {
        try {
            comment.setCreateTime(LocalDateTime.now());
            commentServiceMapper.insert(comment);
            return R.ok("评论成功");
        } catch (Exception e) {
            // 记录日志
            return R.error("评论失败: " + e.getMessage());
        }
    }

    @Override
    public List<Comment> allcomment(int userId) {
        List<Comment> list=commentServiceMapper.findall(userId);
        return list;
    }

    @Override
    public R delete(int id) {
        try {
//
            commentServiceMapper.delete(id);
            return R.ok("删除成功");
        } catch (Exception e) {
            // 记录日志
            return R.error("删除失败: " + e.getMessage());
        }
    }
}
