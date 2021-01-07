package com.inet.entity.po;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @program: springboot
 * @description:信息展示表的实体类
 * @author: xiaoping
 * @create: 2021-01-03 19:00
 **/
@Data
public class Information {
    @ApiModelProperty(value = "id")
    private String id;

    @ApiModelProperty(value = "信息标题")
    private String headline;

    @ApiModelProperty(value = "信息内容")
    private String content;

    @ApiModelProperty(value = "发布者")
    private String author;

    @ApiModelProperty(value = "两弹一星元勋画像的url地址")
    private String photoPath;

    @ApiModelProperty(value = "导弹和战斗机中的小分类")
    private String armamentType;

    @ApiModelProperty(value = "探月和中国天眼的发生时间")
    private Date occurrenceTime;

    @ApiModelProperty(value = "创建时间")
    private Date gmtCreate;

    @ApiModelProperty(value = "修改时间")
    private Date gmtModified;
}
