package com.example.hsms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.hsms.entity.Admin;
import com.example.hsms.entity.Collection;
import com.example.hsms.entity.R;

import java.util.List;

/**
 * @author: ZhangWeiWei
 * @date 2025/5/9
 */
public interface CollectionService extends IService<Collection> {
    R addCollection(int  userId, Integer workerId);

//    R removeCollection(String username, Integer workerId);

    R removeBatch(int userId, List<Integer> workerIds);

    List<Collection> getCollections(int userId);
}
