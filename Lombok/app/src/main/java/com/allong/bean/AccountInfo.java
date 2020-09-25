package com.allong.bean;

import lombok.*;

import java.util.Date;

/**
 * Copyright (C), 2015-2020, 杭州奥朗信息科技有限公司
 * FileName: AccountInfo
 * Author:   YJ
 * Date:     2020/9/25 13:27
 * Description: 账户信息实体类
 * History:
 * <author>          <time>          <version>          <desc>
 * YJ       2020/9/25 13:27        1.0              描述
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountInfo {

    @NonNull
    private Integer id;

    private String userId;

    private String password;

    private Date createTime;

    private Date updateTime;

    private Boolean enable;

    private String status;
}
