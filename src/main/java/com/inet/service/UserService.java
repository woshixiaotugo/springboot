package com.inet.service;

import com.inet.entity.dto.RegisterDTO;
import com.inet.entity.vo.Result;

/**
 * @author Administrator
 */
public interface UserService {
    /**
     * 用户注册
     * @param registerDTO:存储从前端请求中获取到属性的对象
     * @param path:请求路径
     * @return com.inet.entity.vo.Result
     */
    Result saveUser(RegisterDTO registerDTO,String path);

    /**
     * 用户登录
     * @param username:用户名
     * @param password:密码
     * @param path:请求路径
     * @return com.inet.entity.vo.Result
     */
    Result getUser(String username, String password,String path);

    /**
     * 展示当前登录中的用户信息
     * @param token:请求头中接收到的令牌
     * @param path:请求路径
     * @return com.inet.entity.vo.Result
     */
    Result getUserInfo(String token,String path);

    /**
     * 修改当前登录用户的密码
     * @param token:接收的客服端请求的信息对象
     * @param upPassword:用户更新后的密码
     * @param path:请求路径
     * @return com.inet.entity.vo.Result
     */
    Result upUserPassword(String token, String upPassword, String path);
}
