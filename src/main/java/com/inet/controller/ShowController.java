package com.inet.controller;

import com.inet.entity.vo.Result;
import com.inet.service.ShowService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

/**
 * @program: springboot
 * @description: 信息展示的控制层
 * @author: xiaotugou
 * @create: 2021-01-07 16:35
 **/

@Api(tags = {"展示模块"},description = "一些信息的展示")
@CrossOrigin
@RestController
@RequestMapping("/show")
public class ShowController {

    @Resource
    private ShowService showService;

    /**
     * 分页查询动态资讯(新闻)
     * @param page:查询的是第几页
     * @param cont:一页有几条记录
     * @return com.inet.entity.vo.Result
     */
    @ApiOperation("动态资讯")
    @GetMapping("/news")
    public Result news(@RequestParam(value = "Page")Integer page,@RequestParam(value = "Cont")Integer cont){
        //如果传入的页数和每页数量为空或者查看的是第0页 那就让页数等于1，记录数等于5（相当于默认值）
        if (page==null || cont==null || page==0){
            page=1;
            cont=5;
        }
        return showService.listNews(page,cont,"/nationalDefenseScience/show/news");
    }
}
