package com.example.hsms.controller;

import com.example.hsms.entity.Comment;
import com.example.hsms.entity.R;
import com.example.hsms.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: ZhangWeiWei
 * @date 2025/4/4
 */
@RestController
@RequestMapping("/comment")
public class CommentServiceController {
    @Autowired
    private CommentService commentService;

    @PostMapping("/add")
    public R addcomment(@RequestBody Comment comment){
        return commentService.add(comment);
    }

    @GetMapping("/my")
    public R reveal(int userId){
        List<Comment> comment= commentService.allcomment(userId);
        Map<String, Object> map=new HashMap<>();
        map.put("message",comment);
        return R.ok(map);
    }
    @DeleteMapping("/delete/{id}")
    public R cancel(@PathVariable int id){
        return commentService.delete(id);

    }


}
