package com.allong.springdata.service;

import com.allong.springdata.domain.Dept;

import java.util.List;

/**
 * Copyright (C), 2015-2020, 杭州奥朗信息科技有限公司
 * FileName: DeptService
 * Author:   YJ
 * Date:     2020/9/25 15:42
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * YJ       2020/9/25 15:42        1.0              描述
 */
public interface DeptService {
    List<Dept> queryAll();
}
