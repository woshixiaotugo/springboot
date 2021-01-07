package com.inet.controller;

import com.inet.entity.vo.Result;
import com.inet.service.ShowService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

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

    @ApiOperation("动态资讯")
    @GetMapping("/news")
    public Result news(@RequestParam(value = "Page")String page,@RequestParam(value = "Cont")String cont){
        return showService.listNews(page,cont);
    }
}
