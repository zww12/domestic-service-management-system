package com.example.hsms.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.util.List;

/**
 * @author: ZhangWeiWei
 * @date 2025/3/22
 */
@Data
public class Service_smalltype {
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBigTypeid() {
        return bigTypeid;
    }

    public void setBigTypeid(int bigTypeid) {
        this.bigTypeid = bigTypeid;
    }

    private int bigTypeid;
    @TableField(select = false)
    private BigType bigType;
    @TableField(select = false)
    private List<Service_Worker> workerList;
}
