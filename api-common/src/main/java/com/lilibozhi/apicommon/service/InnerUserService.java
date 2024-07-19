package com.lilibozhi.apicommon.service;


import com.lilibozhi.apicommon.model.entity.User;

/**
 * 用户服务
 *
 * @author lilibozhi
 */
public interface InnerUserService {

    /**
     * 数据库中查是否已分配给用户密钥（accessKey）
     *
     * @param accessKey
     * @return
     */
    User getInvokeUser(String accessKey);
}
