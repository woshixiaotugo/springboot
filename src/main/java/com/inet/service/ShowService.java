package com.inet.service;

import com.inet.entity.vo.Result;

/**
 * @author Administrator
 */
public interface ShowService {
    /**
     * 分页查询动态资讯(新闻)
     * @param page:查询的页数
     * @param cont:查询一页有几条
     * @param path:请求路径
     * @return com.inet.entity.vo.Result
     */
    Result listNews(Integer page, Integer cont, String path);
}
