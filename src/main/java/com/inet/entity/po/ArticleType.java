package com.inet.entity.po;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.util.Date;

/**
 * @program: springboot
 * @description:文章类别的实体类
 * @author: xiaoping
 * @create: 2021-01-03 19:00
 **/
@Data
public class ArticleType {
    @ApiModelProperty(value = "id")
    private String id;

    @ApiModelProperty(value = "类别")
    private String type;

    @ApiModelProperty(value = "创建时间")
    private Date gmtCreate;

    @ApiModelProperty(value = "修改时间")
    private Date gmtModified;
}
