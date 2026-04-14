package com.example.hsms.controller;

import com.example.hsms.entity.BigType;
import com.example.hsms.entity.R;
import com.example.hsms.entity.Service_Worker;
import com.example.hsms.entity.Service_smalltype;
import com.example.hsms.service.BigTypeService;
import com.example.hsms.service.Serviceworker;
import com.example.hsms.service.SmallTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: ZhangWeiWei
 * @date 2025/3/11
 */
@RestController
public class BigTypeServiceController {
    @Autowired
    private BigTypeService bigtypeservice;
    @Autowired
    private SmallTypeService smalltypeservice;

    @Autowired
    private Serviceworker serviceworker;

    /*
    查询所有大类
     */
    @GetMapping("/findall")
    public R findall(){
        List<BigType> list=bigtypeservice.bigtypefind();
        Map<String, Object> map=new HashMap<>();
        map.put("message",list);
        return R.ok(map);
    }

    /*
    查询所有小类
     */
    @GetMapping("/findallsamll")
    public R findallsmall(){
        List<Service_smalltype> list=smalltypeservice.findall();
        Map<String, Object> map=new HashMap<>();
        map.put("message",list);
        return R.ok(map);
    }
    /*


     获取所有菜单信息
     */
    @GetMapping("/findCategories")
    public R findCategories(){
        //获取所有大类列表
        List<BigType> bigTypeList=bigtypeservice.bigtypefind();
        for(BigType bigType:bigTypeList){
           //根据大类ID查询关联的小类列表
            List<Service_smalltype> smalltypeList= smalltypeservice.find(bigType.getId());
            // 将小类列表设置到大类对象中
            bigType.setSmalltypeList(smalltypeList);
            // 遍历大类下的每个小类
            for(Service_smalltype smalltype:smalltypeList){
                // 根据小类ID查询关联的工作人员列表
                List<Service_Worker> workerList= serviceworker.WorkerTypefind(smalltype.getId());
                // 将工作人员列表设置到小类对象中
                smalltype.setWorkerList(workerList);
            }
        }
        Map<String,Object> map=new HashMap<>();
        map.put("message",bigTypeList);
        return R.ok(map);
    }




}
