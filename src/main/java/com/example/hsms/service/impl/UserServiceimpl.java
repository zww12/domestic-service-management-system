package com.example.hsms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.hsms.entity.LoginDao;
import com.example.hsms.entity.Reservation;
import com.example.hsms.entity.User;
import com.example.hsms.mapper.AdminReservationMapper;
import com.example.hsms.mapper.UserMapper;
import com.example.hsms.service.UserService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
//import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: ZhangWeiWei
 * @date 2025/3/4
 */
@Service
@Slf4j
@Transactional
public class UserServiceimpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Autowired
    private UserMapper usermapper;

//    @Value("${wechat.appid}")
//    private String appid;
//    @Value("${wechat.secret}")
//    private String secret;


    @Override
    public void add(User user) {
        user.setCreateTime(LocalDateTime.now());
        user.setUpdateTime(LocalDateTime.now());

        usermapper.insert(user);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public User wxLogin(LoginDao logindao) {
        Map<String, String> wxResult = getWxSession(logindao.getCode());
        String openid = wxResult.get("openid");
        String sessionKey = wxResult.get("session_key");

        if (openid == null) {
            throw new RuntimeException("微信登录失败：" + wxResult.get("errmsg"));
        }
        // 2. 查询用户是否存在
        User user = usermapper.selectByOpenid(openid);

        // 3. 不存在则创建新用户
        if (user == null) {
            user = new User();
            user.setOpenid(openid);
            user.setNickName(logindao.getNickname());
            user.setAvatarUrl(logindao.getAvatarurl());
            user.setCreateTime(LocalDateTime.now());
            user.setSessionKey(sessionKey);
            user.setUpdateTime(LocalDateTime.now());
            usermapper.insert(user);
        }
        else {
            // 4. 存在则更新用户信息
            user.setNickName(logindao.getNickname());
//            user.setSessionKey(sessionKey);
            user.setAvatarUrl(logindao.getAvatarurl());
            user.setUpdateTime(LocalDateTime.now());
            usermapper.update(user);
        }

        // 5. 设置微信会话密钥（用于后续解密）
//        user.setSessionKey(sessionKey);
        return user;
    }


    private Map<String, String> getWxSession(String code) {
        String url = "https://api.weixin.qq.com/sns/jscode2session?" +
                "appid=wx6a8a9ac05c4bdc7b&secret=31d7e5930621482b5609f12157fbdc66&js_code={code}&grant_type=authorization_code";

        RestTemplate restTemplate = new RestTemplate();
        Map<String, String> params = new HashMap<>();
        params.put("code", code); // 仅传递 code 参数

        try {
            ResponseEntity<String> response = restTemplate.getForEntity(url, String.class, params);
            String responseBody = response.getBody();
            System.out.println("微信响应内容：" + responseBody); // 调试日志

            if (response.getStatusCode() != HttpStatus.OK) {
                throw new RuntimeException("HTTP 状态码异常: " + response.getStatusCode());
            }

            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(responseBody, new TypeReference<Map<String, String>>() {});
        } catch (HttpClientErrorException | HttpServerErrorException e) {
            String errorBody = e.getResponseBodyAsString();
            throw new RuntimeException("微信接口错误: " + errorBody);
        } catch (Exception e) {
            throw new RuntimeException("解析失败: " + e.getMessage());
        }
    }
}

//    private Map<String, String> getWxSession(String code) {
//        String url = "https://api.weixin.qq.com/sns/jscode2session?" +
//                "appid=wx6a8a9ac05c4bdc7b&secret=31d7e5930621482b5609f12157fbdc66&js_code={code}&grant_type=authorization_code";
//
//        RestTemplate restTemplate = new RestTemplate();
//        Map<String, String> params = new HashMap<>();
//        params.put("appid", "wx6a8a9ac05c4bdc7b");
//        params.put("secret", "31d7e5930621482b5609f12157fbdc66");
//        params.put("code", code);
//
//        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class, params);
//        ObjectMapper mapper = new ObjectMapper();
//
//        try {
//            return mapper.readValue(response.getBody(), new TypeReference<Map<String, String>>(){});
//        } catch (Exception e) {
//            throw new RuntimeException("微信接口响应解析失败");
//        }
//
//
//    }
