package com.inet.entity.po;

import com.alibaba.fastjson.annotation.JSONField;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @program: springboot
 * @description:用户评论表的实体类
 * @author: xiaoping
 * @create: 2021-01-03 19:00
 **/
@Data
public class Comment {
    @ApiModelProperty(value = "id")
    private String id;

    @ApiModelProperty(value = "用户id")
    private String user_id;

    @ApiModelProperty(value = "用户评论的内容")
    private String content;

    @ApiModelProperty(value = "评论的文章的id")
    private String informationId;

    @ApiModelProperty(value = "评论的父评论的id")
    private String parentId;

    /**
     * 属性名不能使用is开头，所以手动映射数据库中is_admin字段
     */
    @ApiModelProperty(value = "是否管理员的评论")
    @JSONField(name = "is_admin")
    private String gamin;

    @ApiModelProperty(value = "创建时间")
    private Date gmtCreate;

    @ApiModelProperty(value = "修改时间")
    private Date gmtModified;
}
