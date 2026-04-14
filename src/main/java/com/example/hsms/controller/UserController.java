package com.example.hsms.controller;

import com.example.hsms.constant.SystemConstant;
import com.example.hsms.entity.LoginDao;
import com.example.hsms.entity.R;
import com.example.hsms.entity.User;
import com.example.hsms.service.UserService;
import com.example.hsms.util.JwtUtils;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: ZhangWeiWei
 * @date 2025/3/4
 */
@RestController
public class UserController {

    @Autowired
    private UserService userservice;

    /**
     * 登陆
     */
//    @PostMapping("/login")
//    public R add(@RequestBody User user){
////        log.info("")
//        //调用service新增部门
//        userservice.add(user);
////        return R.ok("成功");
//        return R.success(200,"success").put("nick_name",user.getNick_name()).put("avatar_url",user.getAvatar_url());
//    }

    @PostMapping("/login")
    public R login(@RequestBody LoginDao loginDTO) {
        try {
            User user = userservice.wxLogin(loginDTO);
//            String token = JwtUtils.generateToken(user.getId().toString());
            String token=JwtUtils.createJWT(user.getOpenid(),user.getNickName(), 7 * 24 * 60 * 60 * 1000L);


            return R.success(200,"success").put("nick_name",user.getNickName()).put("id",user.getId()).put("avatar_url",user.getAvatarUrl()).put("id",user.getId()).put("token",token).put("openid",user.getOpenid());
        } catch (Exception e) {
            return R.error(500, e.getMessage());
        }
    }
}
//@Data
//class UserVO {
//    private String nickName;
//    private String avatarUrl;
//
//    public UserVO(User user) {
//        this.nickName = user.getNickName();
//        this.avatarUrl = user.getAvatarUrl();
//    }
//}
