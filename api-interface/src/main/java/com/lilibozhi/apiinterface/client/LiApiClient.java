//package com.lilibozhi.apiinterface.client;
//
//import cn.hutool.core.util.RandomUtil;
//import cn.hutool.http.HttpRequest;
//import cn.hutool.http.HttpResponse;
//import cn.hutool.http.HttpUtil;
//import cn.hutool.json.JSONUtil;
//import com.lilibozhi.apiinterface.model.User;
//import org.springframework.web.bind.annotation.RequestBody;
//
//import java.util.HashMap;
//import java.util.Map;
//
//import static com.lilibozhi.apiinterface.utils.SignUtils.genSign;
//
///**
// * 调用第三方接口的客户端
// *
// * @author lilibozhi
// */
//public class LiApiClient {
//
//    private String accessKey;
//
//    private String secretKey;
//
//    public LiApiClient(String accessKey, String secretKey) {
//        this.accessKey = accessKey;
//        this.secretKey = secretKey;
//    }
//
//    public String getNameByGet(String name) {
//        HashMap<String, Object> paramMap = new HashMap<>();
//        paramMap.put("name", name);
//        String result = HttpUtil.get("http://localhost:8123/api/name/", paramMap);
//        System.out.println(result);
//        return result;
//
//    }
//
//    public String getNameByPost(String name) {
//        HashMap<String, Object> paramMap = new HashMap<>();
//        paramMap.put("name", name);
//        String result = HttpUtil.post("http://localhost:8123/api/name/", paramMap);
//        System.out.println(result);
//        return result;
//    }
//
//    public String getUserNameByPost(@RequestBody User user) {
//        //将user对象转换为json字符串
//        String json = JSONUtil.toJsonStr(user);
//        HttpResponse httpResponse = HttpRequest.post("http://localhost:8123/api/name/user")
//                .addHeaders(getHeaderMap(json))
//                .body(json)
//                .execute();
//        System.out.println(httpResponse.getStatus());
//        String result = httpResponse.body();
//        System.out.println(result);
//        return result;
//    }
//
//    private Map<String, String> getHeaderMap(String body) {
//        Map<String, String> hashMap = new HashMap<>();
//        hashMap.put("accessKey", accessKey);
//        //hashMap.put("secretKey", secretKey);
//        //生成随机数（生成一个包含4个随机数字的字符串）
//        hashMap.put("nonce", RandomUtil.randomNumbers(4));
//        //请求体内容
//        hashMap.put("body", body);
//
//        //当前时间戳
//        hashMap.put("timestamp", String.valueOf(System.currentTimeMillis() / 1000));
//        hashMap.put("sign",genSign(body,secretKey));
//        return hashMap;
//    }
//}
//
//
