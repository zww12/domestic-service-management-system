package com.example.hsms.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.util.List;

/**
 * @author: ZhangWeiWei
 * @date 2025/3/11
 */
@Data
public class BigType {

    private Integer id;

    public BigType(Integer id, String name, String remark, String image) {
        this.id = id;
        this.name = name;
        this.remark = remark;
        this.image = image;
    }

    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    private String remark;
    private String image;
    @TableField(select = false)
    private List<Service_smalltype> smalltypeList;


}
