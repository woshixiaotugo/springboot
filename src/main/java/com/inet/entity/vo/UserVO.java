package com.inet.entity.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @program: springboot
 * @description: 登录成功后返回的实体类
 * @author: xiaotugou
 * @create: 2021-01-04 19:24
 **/
@Data
public class UserVO implements Serializable {
    @ApiModelProperty(value = "id")
    private String id;

    @ApiModelProperty(value = "用户名")
    private String username;

    @ApiModelProperty(value = "用户密码")
    private String password;

    @ApiModelProperty(value = "用户昵称")
    private String nickname;

    @ApiModelProperty(value = "手机号码")
    private String phoneNumber;

    @ApiModelProperty(value = "用户头像")
    private String photoPath;

    @ApiModelProperty(value = "用户角色")
    private String userRole;

    @ApiModelProperty(value = "创建时间")
    private String gmtCreate;

    @ApiModelProperty(value = "修改时间")
    private String gmtModified;
}
