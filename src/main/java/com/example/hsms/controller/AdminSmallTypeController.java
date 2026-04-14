package com.example.hsms.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.hsms.entity.R;
import com.example.hsms.entity.Service_smalltype;
import com.example.hsms.service.SmallTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: ZhangWeiWei
 * @date 2025/4/11
 */
@RestController
@RequestMapping("/admin/smallType")
public class AdminSmallTypeController {
    @Autowired
    private SmallTypeService smallTypeService;

    /**
     * 根据大类id，查询所有小类
     * @return
     */
    @GetMapping("/listAll/{bigTypeId}")
    public R listAll(@PathVariable(value = "bigTypeId")int bigTypeId){
        Map<String,Object> map=new HashMap<>();
        List<Service_smalltype> list=smallTypeService.find(bigTypeId);
//        map.put("smallTypeList",smallTypeService.list(new QueryWrapper<Service_smalltype>().eq("bigTypeId",bigTypeId)));
       map.put("smallTypeList",list);
        return R.ok(map);
    }

}
