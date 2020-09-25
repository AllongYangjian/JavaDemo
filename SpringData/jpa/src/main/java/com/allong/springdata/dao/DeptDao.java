package com.allong.springdata.dao;

import com.allong.springdata.domain.Dept;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Copyright (C), 2015-2020, 杭州奥朗信息科技有限公司
 * FileName: DeptDao
 * Author:   YJ
 * Date:     2020/9/25 15:40
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * YJ       2020/9/25 15:40        1.0              描述
 */
public interface DeptDao extends JpaRepository<Dept,String> {
}
