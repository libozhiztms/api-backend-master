package com.lilibozhi.project.service.impl.inner;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lilibozhi.apicommon.model.entity.User;
import com.lilibozhi.apicommon.service.InnerUserService;
import com.lilibozhi.project.common.ErrorCode;
import com.lilibozhi.project.exception.BusinessException;
import com.lilibozhi.project.mapper.UserMapper;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.DubboService;

import javax.annotation.Resource;
@DubboService
public class InnerUserServiceImpl implements InnerUserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public User getInvokeUser(String accessKey) {

        if(StringUtils.isAnyBlank(accessKey)){
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("accessKey",accessKey);

        return userMapper.selectOne(queryWrapper);
    }
}
