package com.example.hsms.controller;

import com.example.hsms.entity.Collection;
import com.example.hsms.entity.R;
import com.example.hsms.entity.Reservation;
import com.example.hsms.service.CollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author: ZhangWeiWei
 * @date 2025/5/9
 */
//public class CollectionController {
//}
@RestController
@RequestMapping("/collection")
public class CollectionController {
    @Autowired
    private CollectionService collectionService;

    @PostMapping("/add")
    public R add(@RequestParam int userId,
                 @RequestParam Integer workerId) {
        return collectionService.addCollection(userId, workerId);
    }

//    @PostMapping("/remove")
//    public R remove(@RequestParam String userName,
//                         @RequestParam Integer workerId) {
//        return collectionService.removeCollection(userName, workerId);
//    }

    @GetMapping("/list")
    public R list(@RequestParam int userId) {
//        return R.success(collectionService.getCollections(username));
        List<Collection> list= collectionService.getCollections(userId);
        Map<String, Object> map=new HashMap<>();
        map.put("message",list);
        return R.ok(map);
    }
    @PostMapping("/remove")
    public R removeBatch(@RequestParam int userId,
                         @RequestParam String workerId) { // 接收逗号分隔的ID

            List<Integer> ids = Arrays.stream(workerId.split(","))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            return collectionService.removeBatch(userId, ids);
    }


}
