package com.inet.entity.po;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @program: springboot
 * @description:文章类别关系表的实体类
 * @author: xiaoping
 * @create: 2021-01-03 19:00
 **/
@Data
public class InformationType {
    @ApiModelProperty(value = "id")
    private String id;

    @ApiModelProperty(value = "文章id")
    private String informationId;

    @ApiModelProperty(value = "类别id")
    private String typeId;

    @ApiModelProperty(value = "创建时间")
    private Date gmtCreate;

    @ApiModelProperty(value = "修改时间")
    private Date gmtModified;
}
