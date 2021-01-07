package com.inet.entity.po;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @program: springboot
 * @description:图片表的实体类
 * @author: xiaoping
 * @create: 2021-01-03 19:00
 **/
@Data
public class Image {
    @ApiModelProperty(value = "id")
    private String id;

    @ApiModelProperty(value = "图片url地址")
    private String url;

    @ApiModelProperty(value = "属于哪个文章的id")
    private String informationId;

    @ApiModelProperty(value = "创建时间")
    private Date gmtCreate;

    @ApiModelProperty(value = "修改时间")
    private Date gmtModified;
}
