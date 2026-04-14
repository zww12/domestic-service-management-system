package com.example.hsms.controller;

import com.example.hsms.entity.R;
import com.example.hsms.service.BigTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: ZhangWeiWei
 * @date 2025/4/11
 */
@RestController
@RequestMapping("/admin/bigType")
public class AdminBigTypeController {
    @Autowired
    private BigTypeService bigTypeService;

    @RequestMapping("/listAll")
    public R listAll(){
        Map<String,Object> map=new HashMap<>();
        map.put("bigTypeList",bigTypeService.bigtypefind());
        return R.ok(map);
    }
}
