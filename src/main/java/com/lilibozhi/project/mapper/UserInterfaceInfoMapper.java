package com.lilibozhi.project.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lilibozhi.apicommon.model.entity.UserInterfaceInfo;

import java.util.List;

/**
 * @author lilibozhi
 * @description 针对表【user_interface_info(用户调用接口关系)】的数据库操作Mapper
 * @createDate 2024-07-12 09:08:01
 * @Entity com.lilibozhi.project.model.entity.UserInterfaceInfo
 */
public interface UserInterfaceInfoMapper extends BaseMapper<UserInterfaceInfo> {
//select interfaceInfoId,sum(totalNum) as totalNum
//from user_interface_info
//group by interfaceInfoId
//order by totalNum desc
//limit 3
    //查询用户接口信息表中，按照指定的limit参数进行筛选
    List<UserInterfaceInfo> listTopInvokeInterfaceInfo(int limit);
}




