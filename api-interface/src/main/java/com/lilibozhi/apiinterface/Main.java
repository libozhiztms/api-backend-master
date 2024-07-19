//package com.lilibozhi.apiinterface;
//
//import com.lilibozhi.apiinterface.client.LiApiClient;
//import com.lilibozhi.apiinterface.model.User;
//
//public class Main {
//    public static void main(String[] args) {
//
//        String accessKey="libozhi";
//        String secretKey="abcdefgh";
//        LiApiClient liApiClient = new LiApiClient(accessKey,secretKey);
//        String result1=liApiClient.getNameByGet("lbz");
//        String result2=liApiClient.getNameByPost("libozhi");
//        User user=new User();
//        user.setUsername("lilibozhi");
//
//        String result3=liApiClient.getUserNameByPost(user);
//        System.out.println(result1);
//        System.out.println(result2);
//        System.out.println(result3);
//    }
//}
