package com.mengxuegu.blog.entities;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 用户信息表
 * </p>
 *
 * @author yangjian
 * @since 2021-07-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("sys_user")
@ApiModel(value="User对象", description="用户信息表")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "用户 ID")
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private String id;

    @ApiModelProperty(value = "用户名")
    @TableField("username")
    private String username;

    @ApiModelProperty(value = "密码，加密存储, admin/1234")
    @TableField("password")
    private String password;

    @ApiModelProperty(value = "帐户是否过期(1 未过期，0已过期)")
    @TableField("is_account_non_expired")
    private Integer isAccountNonExpired;

    @ApiModelProperty(value = "帐户是否被锁定(1 未过期，0已过期)")
    @TableField("is_account_non_locked")
    private Integer isAccountNonLocked;

    @ApiModelProperty(value = "密码是否过期(1 未过期，0已过期)")
    @TableField("is_credentials_non_expired")
    private Integer isCredentialsNonExpired;

    @ApiModelProperty(value = "帐户是否可用(1 可用，0 删除用户)")
    @TableField("is_enabled")
    private Integer isEnabled;

    @ApiModelProperty(value = "昵称")
    @TableField("nick_name")
    private String nickName;

    @ApiModelProperty(value = "头像url")
    @TableField("image_url")
    private String imageUrl;

    @ApiModelProperty(value = "注册手机号")
    @TableField("mobile")
    private String mobile;

    @ApiModelProperty(value = "注册邮箱")
    @TableField("email")
    private String email;

    @ApiModelProperty(value = "创建时间")
    @TableField("create_date")
    private Date createDate;

    @ApiModelProperty(value = "更新时间")
    @TableField("update_date")
    private Date updateDate;

    @ApiModelProperty(value = "密码更新时间")
    @TableField("pwd_update_date")
    private Date pwdUpdateDate;


}
