package com.mengxuegu.blog.system.req;

import com.mengxuegu.blog.entities.Role;
import com.mengxuegu.blog.util.base.BaseRequest;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@ApiModel(value = "SysRoleREQ对象", description = "角色查询条件")
public class SysRoleREQ extends BaseRequest<Role> {

    @ApiModelProperty(value = "角色名称")
    private String name;

}
