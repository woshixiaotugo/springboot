package com.inet.service.impl;

import com.inet.entity.po.Information;
import com.inet.entity.vo.Result;
import com.inet.mapper.ShowMapper;
import com.inet.service.ShowService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: springboot
 * @description: 信息展示
 * @author: xiaotugou
 * @create: 2021-01-07 17:48
 **/
@Service
public class ShowServiceImpl implements ShowService {

    @Resource
    private ShowMapper showMapper;

    /**
     * 分页查询新闻
     * @param page:查询的页数
     * @param cont:查询一页有几条
     * @return com.inet.entity.vo.Result
     */
    @Override
    public Result listNews(Integer page, Integer cont, String path) {
        //(page-1)是sql语句中limit的查询起始值，cont为查询几条.(从第几条开始，查询几条记录),这样就可以实现分页查询
        List<Information> informationList = showMapper.listNews((page-1)*cont,cont);
        //如果查询的结果为不为空，就将查询到的记录返回给前端
        if (informationList!=null){
            return new Result().result200(informationList,path);
        }
        return new Result().result500("未知错误",path);
    }
}
