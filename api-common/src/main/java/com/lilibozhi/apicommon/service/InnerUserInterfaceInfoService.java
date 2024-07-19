package com.lilibozhi.apicommon.service;

/**
 * @author lilibozhi
 * @description 针对表【user_interface_info(用户调用接口关系)】的数据库操作Service
 * @createDate 2024-07-12 09:08:01
 */
public interface InnerUserInterfaceInfoService {

    /**
     * 调用接口统计
     *
     * @param interfaceInfoId
     * @param userId
     * @return
     */
    boolean invokeCount(long interfaceInfoId, long userId);
}
