package com.poi.dudu.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.poi.dudu.repository.UserRepository;
import com.poi.dudu.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author eisuto
 */
@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    /**
     * 约定返回格式
     * @param code  标识码
     * @param data  数据
     * @return JSON
     */
    private static String putJson(String code, Object data){
        JSONObject result = new JSONObject();
        result.put("code", code);
        result.put("data", data);
        return JSON.toJSONString(result);
    }

    /**
     * 注册（未完成）
     * @param user 用户
     * @return JSON
     */
    @RequestMapping("/user/register")
    public String register(@RequestBody User user) {
        userRepository.save(user);
        return "index";
    }

    /**
     * 登录
     * @param phone 手机号码
     * @param password 密码
     * @return 成功code字段为200 反之500
     */
    @RequestMapping("/user/login")
    public String login(String phone,String password) {
        String code = "200";
        User u =  userRepository.findByPhoneAndPassword(phone,password);
        if(u==null) {
            code = "500";
        }
        return putJson(code,u);
    }
}
