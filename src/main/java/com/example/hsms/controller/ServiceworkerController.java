package com.example.hsms.controller;

import com.example.hsms.entity.Comment;
import com.example.hsms.entity.R;
import com.example.hsms.entity.Service_Worker;
import com.example.hsms.service.CommentService;
import com.example.hsms.service.Serviceworker;
import javafx.concurrent.Worker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: ZhangWeiWei
 * @date 2025/3/6
 */
@RestController
@RequestMapping("/worker")
public class ServiceworkerController {
    @Autowired
    private Serviceworker serviceworker;
    @Autowired
    private CommentService commentService;

    /**
     * 查询轮播图
     */
    @GetMapping("/findswiper")
    public R findswiper(){
        List<Service_Worker> list=serviceworker.Serviceworkerfind();
        Map<String, Object> map=new HashMap<>();
        map.put("message",list);
        return R.ok(map);

    }
    @GetMapping("/recommend")
    public R recommend(){
        List<Service_Worker> list=serviceworker.Serviceworkerrecommend();
        Map<String, Object> map=new HashMap<>();
        map.put("message",list);
        return R.ok(map);
    }
    @GetMapping("/detail")
    public R detail(int id){
        Service_Worker worker= serviceworker.WorkerDetail(id);
        Map<String, Object> map=new HashMap<>();
        map.put("message",worker);
        return R.ok(map);
    }
    @GetMapping("/comment")
    public R comment(int id){
        List<Comment> comment= commentService.WorkerComment(id);
        Map<String, Object> map=new HashMap<>();
        map.put("message",comment);
        return R.ok(map);
    }
    @GetMapping("/search")
    public R search(String s){
        List<Service_Worker> list=serviceworker.search(s);
        Map<String, Object> map=new HashMap<>();
        map.put("message",list);
        return R.ok(map);
    }



}
