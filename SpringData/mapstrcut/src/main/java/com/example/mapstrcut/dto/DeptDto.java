package com.example.mapstrcut.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Copyright (C), 2015-2020, 杭州奥朗信息科技有限公司
 * FileName: DeptDto
 * Author:   YJ
 * Date:     2020/9/28 13:47
 * Description: 科室对象
 * History:
 * <author>          <time>          <version>          <desc>
 * YJ       2020/9/28 13:47        1.0              描述
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class DeptDto {

    private Integer deptId;

    private String deptName;
}
