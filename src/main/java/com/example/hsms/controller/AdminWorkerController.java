package com.example.hsms.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.hsms.constant.SystemConstant;
import com.example.hsms.entity.PageBean;
import com.example.hsms.entity.R;
import com.example.hsms.entity.Service_Worker;
import com.example.hsms.entity.WorkerDao;
import com.example.hsms.service.AdminWorkerService;
import com.example.hsms.service.Serviceworker;
import com.example.hsms.util.DateUtil;
import com.example.hsms.util.JwtUtils;
import com.example.hsms.util.StringUtil;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: ZhangWeiWei
 * @date 2025/4/8
 */
@RestController
@RequestMapping("/admin/worker")
public class AdminWorkerController {
    @Autowired
    private AdminWorkerService adminWorkerService;
    @Value("${workerImagesFilePath}")
    private String workerImagesFilePath;

    @Value("${swiperImagesFilePath}")
    private String swiperImagesFilePath;


//    @PostMapping("/login")
//    public R login(@RequestBody WorkerDao loginRequest){
////        if(admin==null){
////            return R.error();
////        }
//        String username = loginRequest.getUsername();
//        String password = loginRequest.getPassword();
//        if(StringUtil.isEmpty(username)){
//            return R.error("用户名不能为空！");
//        }
//        if(StringUtil.isEmpty(password)){
//            return R.error("密码不能为空！");
//        }
//        Service_Worker resultAdmin = adminWorkerService.getOne(new QueryWrapper<Service_Worker>().eq("username", username));
//        if(resultAdmin==null){
//            return R.error("用户名不存在");
//        }
//        if(!resultAdmin.getPassword().trim().equals(password)){
//            return R.error("用户名或者密码错误！");
//        }
//        String token = JwtUtils.createJWT("-1", "worker", SystemConstant.JWT_TTL);
//        Map<String,Object> resultMap=new HashMap<>();
//        resultMap.put("token",token);
//        resultMap.put("username",resultAdmin.getUsername());
//        resultMap.put("password",resultAdmin.getPassword());
//        return R.ok(resultMap);
//    }


    @RequestMapping("/list")
//@PostMapping("/list")
    public R list(@RequestBody PageBean pageBean){
        System.out.println(pageBean);
        Map<String,Object> map=new HashMap<>();
        map.put("name",pageBean.getQuery().trim());
        map.put("start",pageBean.getStart());
        map.put("pageSize",pageBean.getPageSize());
        List<Service_Worker> workerList=adminWorkerService.list(map);
        Long total=adminWorkerService.getTotal(map);

        Map<String,Object> resultMap=new HashMap<>();
        resultMap.put("workerList",workerList);
        resultMap.put("total",total);
        return R.ok(resultMap);
    }
    /**
     * 更新swiper状态
     * @param id
     * @param swiper
     * @return
     */
    @GetMapping("/updateSwiper/{id}/state/{swiper}")
    public R updateSwiper(@PathVariable(value = "id")int id, @PathVariable(value = "swiper")boolean swiper){
        Service_Worker worker = adminWorkerService.getById(id);
        worker.setSwiper(swiper);
        adminWorkerService.saveOrUpdate(worker);
        return R.ok();
    }
    /**
     * 删除
     * @param id
     * @return
     */
    @GetMapping("/delete/{id}")
    public R delete(@PathVariable(value = "id")Integer id){
        adminWorkerService.removeById(id);
        return R.ok();
    }

    /**
     * 上传家政人员图片
     * @param file
     * @return
     * @throws Exception
     */
    @RequestMapping("/uploadImage")
    public Map<String,Object> uploadImage(MultipartFile file)throws Exception{
        Map<String,Object> resultMap=new HashMap<>();
        if(!file.isEmpty()){
            String originalFilename = file.getOriginalFilename();
            String suffixName=originalFilename.substring(originalFilename.lastIndexOf("."));
            String newFileName= DateUtil.getCurrentDateStr()+suffixName;
            FileUtils.copyInputStreamToFile(file.getInputStream(),new File(workerImagesFilePath+newFileName));
            resultMap.put("code",0);
            resultMap.put("msg","上传成功");
            Map<String,Object> dataMap=new HashMap<>();
            dataMap.put("title",newFileName);
            dataMap.put("src","/image/worker/"+newFileName);
            resultMap.put("data",dataMap);
        }
        return resultMap;
    }

    /**
     * 添加或者修改
     * @param worker
     * @return
     * 多表，要自己定义sql语句
     * 有个type（级联），报错
     */
    @RequestMapping("/save")
    public R save(@RequestBody Service_Worker worker){
        if(worker.getId()==null || worker.getId()==-1){
            adminWorkerService.add(worker);
        }else{
            adminWorkerService.update(worker);
        }
        return R.ok();
    }
    @RequestMapping("/uploadSwiperImage")
    public Map<String,Object> uploadSwiperImage(MultipartFile file)throws Exception{
        Map<String,Object> resultMap=new HashMap<>();
        if(!file.isEmpty()){
            // 获取文件名
            String originalFilename = file.getOriginalFilename();
            String suffixName=originalFilename.substring(originalFilename.lastIndexOf("."));
            String newFileName= DateUtil.getCurrentDateStr()+suffixName;
            FileUtils.copyInputStreamToFile(file.getInputStream(),new File(swiperImagesFilePath+newFileName));
            resultMap.put("code",0);
            resultMap.put("msg","上传成功");
            Map<String,Object> dataMap=new HashMap<>();
            dataMap.put("title",newFileName);
            dataMap.put("src","/image/swiper/"+newFileName);
            resultMap.put("data",dataMap);
        }
        return resultMap;
    }

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public R findById(@PathVariable(value = "id")int id){
        Service_Worker worker = adminWorkerService.findById(id);
        Map<String,Object> map=new HashMap<>();
        map.put("worker",worker);
        return R.ok(map);
    }
}
