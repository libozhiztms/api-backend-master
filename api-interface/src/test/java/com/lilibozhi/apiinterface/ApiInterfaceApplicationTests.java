package com.lilibozhi.apiinterface;

import com.lilibozhi.apiclientsdk.client.LiApiClient;
import com.lilibozhi.apiclientsdk.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class ApiInterfaceApplicationTests {

    @Resource
    LiApiClient liApiClient;
    @Test
    void contextLoads() {
        String result = liApiClient.getNameByGet("lilililibozhi");
        User user = new User();
        user.setUsername("lbz");
        String usernameByPost = liApiClient.getUserNameByPost(user);
        System.out.println(result);
        System.out.println(usernameByPost);
    }

}
