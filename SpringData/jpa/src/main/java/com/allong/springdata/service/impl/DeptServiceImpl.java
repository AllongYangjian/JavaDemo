package com.allong.springdata.service.impl;

import com.allong.springdata.dao.DeptDao;
import com.allong.springdata.domain.Dept;
import com.allong.springdata.service.DeptService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Copyright (C), 2015-2020, 杭州奥朗信息科技有限公司
 * FileName: DeptServiceImpl
 * Author:   YJ
 * Date:     2020/9/25 15:43
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * YJ       2020/9/25 15:43        1.0              描述
 */
@Service
@RequiredArgsConstructor
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptDao deptDao;

    @Override
    public List<Dept> queryAll() {
        return deptDao.findAll();
    }
}
