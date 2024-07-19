package com.lilibozhi.project.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lilibozhi.apicommon.model.entity.InterfaceInfo;

/**
* @author lilibozhi
* @description 针对表【interface_info(接口信息)】的数据库操作Service
* @createDate 2024-06-09 15:54:07
*/
public interface InterfaceInfoService extends IService<InterfaceInfo> {
    void validInterfaceInfo(InterfaceInfo interfaceInfo, boolean add);
}
