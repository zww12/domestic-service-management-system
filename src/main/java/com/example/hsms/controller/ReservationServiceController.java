package com.example.hsms.controller;

import com.example.hsms.constant.SystemConstant;
import com.example.hsms.entity.CheckResult;
import com.example.hsms.entity.R;
import com.example.hsms.entity.Reservation;
import com.example.hsms.service.ReservationService;
import com.example.hsms.util.JwtUtils;
import com.example.hsms.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.jsonwebtoken.Claims;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: ZhangWeiWei
 * @date 2025/3/31
 */
@RestController
@RequestMapping("/reserve")
public class ReservationServiceController {
    @Autowired
    private ReservationService reservationService;

     @PostMapping("/create")
     public R create(@RequestBody Reservation reservation){
         return reservationService.add(reservation);
     }
    @PostMapping("/update")
    public R update(@RequestBody Reservation reservation){

//        return reservationService.add(reservation);
        return reservationService.update(reservation);
    }
    @GetMapping("/reveal")
    public R reveal(int userId){
        List<Reservation> list= reservationService.select(userId);
        Map<String, Object> map=new HashMap<>();
        map.put("message",list);
        return R.ok(map);
    }
    @DeleteMapping("/cancel/{id}")
    public R cancel(@PathVariable int id){
        return reservationService.delete(id);

    }
    @GetMapping("/find/{id}")
    public R find(@PathVariable int id){
        Reservation reservation=reservationService.find(id);
        Map<String, Object> map=new HashMap<>();
        map.put("message",reservation);
        return R.ok(map);
    }

}
