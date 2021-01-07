package com.inet.entity.po;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.checkerframework.checker.units.qual.A;

import java.util.Date;

/**
 * @program: springboot
 * @description:用户留言表的实体类
 * @author: xiaoping
 * @create: 2021-01-03 19:00
 **/
@Data
public class LeaveMessage {
    @ApiModelProperty(value = "id")
    private String id;

    @ApiModelProperty(value = "用户id")
    private String userId;

    @ApiModelProperty(value = "用户留言内容")
    private String content;

    @ApiModelProperty(value = "创建时间")
    private Date gmtCreate;

    @ApiModelProperty(value = "修改时间")
    private Date gmtModified;
}
