package com.example.hsms.entity;

import lombok.Data;

/**
 * @author: ZhangWeiWei
 * @date 2025/3/4
 */
@Data
public class LoginDao {
    private String code;
    private String nickname;
    private String avatarurl;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getAvatarurl() {
        return avatarurl;
    }

    public void setAvatarurl(String avatarurl) {
        this.avatarurl = avatarurl;
    }
}
