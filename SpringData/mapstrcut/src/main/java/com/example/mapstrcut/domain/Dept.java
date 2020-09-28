package com.example.mapstrcut.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Copyright (C), 2015-2020, 杭州奥朗信息科技有限公司
 * FileName: Dept
 * Author:   YJ
 * Date:     2020/9/28 13:46
 * Description: 科室
 * History:
 * <author>          <time>          <version>          <desc>
 * YJ       2020/9/28 13:46        1.0              描述
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Dept {

    private Integer deptId;

    private String deptName;
}
