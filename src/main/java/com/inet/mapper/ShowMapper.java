package com.inet.mapper;

import com.inet.entity.po.Information;

import java.util.List;

/**
 * @author Administrator
 */
public interface ShowMapper {
    /**
     * 分页查询动态资讯
     * @param page:查询的是页数
     * @param cont:一页有几条
     * @return
     */
    List<Information> listNews(Integer page, Integer cont);
}
