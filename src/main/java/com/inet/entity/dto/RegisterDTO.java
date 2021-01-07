package com.inet.entity.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @program: springboot
 * @description: 接收前端用户注册信息的实体类
 * @author: xiaotugou
 * @create: 2021-01-03 20:11
 **/
@Data
public class RegisterDTO {
    @ApiModelProperty(value = "用户名")
    private String username;

    @ApiModelProperty(value = "用户密码")
    private String password;

    @ApiModelProperty(value = "用户昵称")
    private String nickname;

    @ApiModelProperty(value = "手机号码")
    private String phoneNumber;

}
