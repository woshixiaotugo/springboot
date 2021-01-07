package com.inet.entity.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @program: springboot
 * @description: 用来存放查询到的动态资讯的实体类
 * @author: xiaotugou
 * @create: 2021-01-07 19:41
 **/
@Data
public class NewVO {
    @ApiModelProperty(value = "id")
    private String id;

    @ApiModelProperty(value = "新闻标题")
    private String headline;

    @ApiModelProperty(value = "新闻内容")
    private String content;

    @ApiModelProperty(value = "新闻作者")
    private String author;

    @ApiModelProperty(value = "创建时间")
    private Date gmtCreate;

    @ApiModelProperty(value = "修改时间")
    private Date gmtModified;
}
