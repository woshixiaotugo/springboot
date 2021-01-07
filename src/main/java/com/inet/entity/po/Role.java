package com.inet.entity.po;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @program: springboot
 * @description:角色表的实体类
 * @author: xiaoping
 * @create: 2021-01-03 19:00
 **/
@Data
public class Role {
    @ApiModelProperty(value = "id")
    private String id;

    @ApiModelProperty(value = "角色名字")
    private String name;

    @ApiModelProperty(value = "创建时间")
    private Date gmtCreate;

    @ApiModelProperty(value = "修改时间")
    private Date gmtModified;
}
