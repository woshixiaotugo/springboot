package com.inet.service;

import com.inet.entity.vo.Result;

/**
 * @author Administrator
 */
public interface ShowService {
    /**
     * 分页查询动态资讯
     * @param page:查询的页数
     * @param cont:查询一页有几条
     * @return com.inet.entity.vo.Result
     */
    Result listNews(String page, String cont);
}
