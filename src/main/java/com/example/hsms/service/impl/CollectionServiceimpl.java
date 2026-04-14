package com.example.hsms.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.hsms.entity.Collection;
import com.example.hsms.entity.R;
import com.example.hsms.entity.User;
import com.example.hsms.mapper.AdminUserMapper;
import com.example.hsms.mapper.CollectionServiceMapper;
import com.example.hsms.service.AdminUserService;
import com.example.hsms.service.CollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: ZhangWeiWei
 * @date 2025/5/9
 */
@Service("CollectionService")
public class CollectionServiceimpl extends ServiceImpl<CollectionServiceMapper, Collection> implements CollectionService {
    @Autowired
    private CollectionServiceMapper collectionServiceMapper;
    @Override
    public R addCollection(int userId, Integer workerId) {
//        return false;
        Collection collection = new Collection();
        collection.setUserId(userId);
        collection.setWorkerId(workerId);
//        try {
//            return collectionServiceMapper.insert(collection) > 0;
//        } catch (DuplicateKeyException e) {
//            throw new RuntimeException("不能重复收藏");
//        }

        try {
            collectionServiceMapper.insert(collection);
            return R.ok("收藏成功");
        } catch (Exception e) {
            // 记录日志
            return R.error("收藏失败: " + e.getMessage());
        }
    }

//    @Override
//    public R removeCollection(int userId, Integer workerId) {
////        return false;
//        QueryWrapper<Collection> wrapper = new QueryWrapper<>();
//        wrapper.eq("user_id", userId)
//                .eq("worker_id", workerId);
////        return collectionServiceMapper.delete(wrapper) > 0;
//        try {
//            collectionServiceMapper.delete(wrapper);
//            return R.ok("删除成功");
//        } catch (Exception e) {
//            // 记录日志
//            return R.error("删除失败: " + e.getMessage());
//        }
//    }

    @Override
    public R removeBatch(int userId, List<Integer> workerIds) {
        QueryWrapper<Collection> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id", userId)
                .in("worker_id", workerIds);
        try {
            collectionServiceMapper.delete(wrapper);
            return R.ok("删除成功");
        } catch (Exception e) {
            return R.error("删除失败: " + e.getMessage());
        }
    }
    @Override
    public List<Collection> getCollections(int userId) {
        return collectionServiceMapper.findByUserId(userId);
    }
}
