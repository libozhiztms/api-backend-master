package com.lilibozhi.apiinterface.controller;

import com.lilibozhi.apiclientsdk.model.User;
import com.lilibozhi.apiclientsdk.utils.SignUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * 名称API
 *
 * @author lilibozhi
 */
@RestController
@RequestMapping("/name")
public class NameController {
    @GetMapping("/")
    public String getNameByGet(String name) {
        return "GET 你的名字是" + name;
    }

    @PostMapping("/")
    public String getNameByPost(@RequestParam String name) {
        return "POST 你的名字是" + name;
    }

    @PostMapping("/user")
    public String getUserNameByPost(@RequestBody User user, HttpServletRequest request) {
//        String accessKey = request.getHeader("accessKey");
//        String nonce = request.getHeader("nonce");
//        String timestamp = request.getHeader("timestamp");
//        String sign = request.getHeader("sign");
//        String body = request.getHeader("body");

        //todo 实际情况应该是去数据库查是否已分配给用户
//        if (!accessKey.equals("libozhi")) {
//            throw new RuntimeException("无权限");
//        }
//        if (Long.parseLong(nonce) > 10000) {
//            throw new RuntimeException("无权限");
//        }

        //todo 时间和当前时间不能超过五分钟
        //if(timestamp){}

        //todo 实际情况是从数据库查出 secretKey
//        String serverSign = SignUtils.genSign(body, "abcdefgh");
//        if (!sign.equals(serverSign)) {
//            throw new RuntimeException("无权限");
//        }
        String result = "POST 用户名字是" + user.getUsername();

        return result;
    }
}
