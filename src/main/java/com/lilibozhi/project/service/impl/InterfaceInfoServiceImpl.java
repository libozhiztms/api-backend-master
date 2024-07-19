package com.lilibozhi.project.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lilibozhi.apicommon.model.entity.InterfaceInfo;
import com.lilibozhi.project.common.ErrorCode;
import com.lilibozhi.project.exception.BusinessException;
import com.lilibozhi.project.service.InterfaceInfoService;
import com.lilibozhi.project.mapper.InterfaceInfoMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

/**
* @author lilibozhi
* @description 针对表【interface_info(接口信息)】的数据库操作Service实现
* @createDate 2024-06-09 15:54:07
*/
@Service
public class InterfaceInfoServiceImpl extends ServiceImpl<InterfaceInfoMapper, InterfaceInfo>
    implements InterfaceInfoService{


    @Override
    public void validInterfaceInfo(InterfaceInfo interfaceInfo, boolean add) {
        //判断接口信息对象是否为空
        if (interfaceInfo==null){
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        //获取接口信息对象的名称
        String name = interfaceInfo.getName();

        //如果是添加操作，所有参数必须为非空
        if(add){
            if(StringUtils.isAnyBlank(name)){
                throw new BusinessException(ErrorCode.PARAMS_ERROR);
            }
        }
        //如果接口名称不为空且长度大于50，抛出异常
        if(StringUtils.isNotBlank(name)&&name.length()>50){
            throw new BusinessException(ErrorCode.PARAMS_ERROR,"名称过长");
        }
    }
}




