package com.example.hsms.service.impl;

import com.example.hsms.entity.BigType;
import com.example.hsms.mapper.BigTypeServiceMapper;
import com.example.hsms.service.BigTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: ZhangWeiWei
 * @date 2025/3/11
 */
@Service
public class BigTypeServiceimpl implements BigTypeService {
    @Autowired
    private BigTypeServiceMapper bigtypemapper;

    @Override
    public List<BigType> bigtypefind() {
        List<BigType> list=bigtypemapper.findall();
        return list;
    }


}
