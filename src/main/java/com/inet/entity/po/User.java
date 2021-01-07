package com.inet.entity.po;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @program: springboot
 * @description:用户表的实体类
 * @author: xiaoping
 * @create: 2021-01-03 19:00
 **/
@Data
public class User {
    @ApiModelProperty(value = "id")
    private String id;

    @ApiModelProperty(value = "用户名")
    private String username;

    @ApiModelProperty(value = "用户昵称")
    private String nickname;

    @ApiModelProperty(value = "手机号码")
    private String phoneNumber;

    @ApiModelProperty(value = "用户头像")
    private String photoPath;

    @ApiModelProperty(value = "创建时间")
    private Date gmtCreate;

    @ApiModelProperty(value = "修改时间")
    private Date gmtModified;
}
