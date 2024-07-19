package com.lilibozhi.project.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.lilibozhi.apicommon.model.entity.InterfaceInfo;
import com.lilibozhi.apicommon.model.entity.UserInterfaceInfo;
import com.lilibozhi.project.annotation.AuthCheck;
import com.lilibozhi.project.common.BaseResponse;
import com.lilibozhi.project.common.ErrorCode;
import com.lilibozhi.project.common.ResultUtils;
import com.lilibozhi.project.exception.BusinessException;
import com.lilibozhi.project.mapper.UserInterfaceInfoMapper;
import com.lilibozhi.project.model.vo.InterfaceInfoVO;
import com.lilibozhi.project.service.InterfaceInfoService;
import com.lilibozhi.project.service.UserInterfaceInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 分析控制器
 */
@RestController
@RequestMapping("/analysis")
@Slf4j
public class AnalysisController {

    @Resource
    private UserInterfaceInfoMapper userInterfaceInfoMapper;

    @Resource
    private InterfaceInfoService interfaceInfoService;

    /**
     * 获取调用次数最多的接口信息列表
     *
     * @return
     */
    @GetMapping("/top/interface/invoke")
    @AuthCheck(mustRole = "admin")
    public BaseResponse<List<InterfaceInfoVO>> listTopInvokeInterfaceInfo() {
        List<UserInterfaceInfo> userInterfaceInfoList = userInterfaceInfoMapper.listTopInvokeInterfaceInfo(3);
        //将接口信息按照接口id进行分组，便于关联查询
        Map<Long, List<UserInterfaceInfo>> interfaceInfoIdObjMap = userInterfaceInfoList.stream()
                .collect(Collectors.groupingBy(UserInterfaceInfo::getInterfaceInfoId));

        QueryWrapper<InterfaceInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.in("id", interfaceInfoIdObjMap.keySet());

        List<InterfaceInfo> list = interfaceInfoService.list(queryWrapper);
        if (CollectionUtils.isEmpty(list)) {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR);
        }

        List<InterfaceInfoVO> interfaceInfoVOList = list.stream().map(interfaceInfo -> {
            InterfaceInfoVO interfaceInfoVO = new InterfaceInfoVO();
            BeanUtils.copyProperties(interfaceInfo, interfaceInfoVO);
            int totalNum = interfaceInfoIdObjMap.get(interfaceInfo.getId()).get(0).getTotalNum();
            interfaceInfoVO.setTotalNUm(totalNum);
            return interfaceInfoVO;
        }).collect(Collectors.toList());

        return ResultUtils.success(interfaceInfoVOList);
    }
}
