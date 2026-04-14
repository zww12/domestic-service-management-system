package com.example.hsms.service;

import com.example.hsms.entity.Comment;
import com.example.hsms.entity.R;

import java.util.List;

/**
 * @author: ZhangWeiWei
 * @date 2025/3/25
 */
public interface CommentService {
    List<Comment> WorkerComment(int id);

    R add(Comment comment);

    List<Comment> allcomment(int userId);

    R delete(int id);


}
