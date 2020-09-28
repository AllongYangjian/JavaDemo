package com.example.mapstrcut.mapper;

import com.example.mapstrcut.domain.Dept;
import com.example.mapstrcut.dto.DeptDto;
import org.mapstruct.Mapper;

/**
 * Copyright (C), 2015-2020, 杭州奥朗信息科技有限公司
 * FileName: DeptConvertMapper
 * Author:   YJ
 * Date:     2020/9/28 13:48
 * Description: 转换类
 * History:
 * <author>          <time>          <version>          <desc>
 * YJ       2020/9/28 13:48        1.0              描述
 */
@Mapper(componentModel = "spring")
public interface DeptConvertMapper {
    Dept toEntity(DeptDto dto);


    DeptDto toDto(Dept entity);

}
