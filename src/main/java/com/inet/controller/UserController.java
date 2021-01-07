package com.inet.controller;

import com.inet.entity.dto.RegisterDTO;
import com.inet.entity.vo.Result;
import com.inet.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;

/**
 * @program: springboot
 * @description:
 * @author: xiaotugou
 * @create: 2021-01-03 20:02
 **/
@Api(tags = {"用户模块"},description = "用户登录，注册")
@CrossOrigin
@RestController
@RequestMapping("/userBase")
public class UserController {

    @Resource
    private UserService userService;

    /**
     *用户注册
     * @param registerDTO:从前端获取的数据的实体类
     * @return 自定义返回值
     */
    @ApiOperation("用户注册")
    @PostMapping("/user")
    public Result postUser(@RequestBody RegisterDTO registerDTO){
        return userService.saveUser(registerDTO,"/nationalDefenseScience/userBase/user");
    }

    /**
     * 用户登录
     * @param username:用户名
     * @param password:密码
     * @return 自定义返回值
     */
    @ApiOperation("用户登录")
    @GetMapping("/user")
    public Result getUser(@RequestParam(value = "Username")String username,@RequestParam(value = "Password")String password){
        return userService.getUser(username,password,"/nationalDefenseScience/userBase/user");
    }

    /**
     * 获取当前登录中的用户信息
     * @param token:请求头中的Token
     * @return 自定义返回值
     */
    @ApiOperation("获取当前登录中的用户信息")
    @GetMapping("/getUserInfo")
    public Result getUserInfo(@RequestHeader(value = "Token")String token){
        return userService.getUserInfo(token,"/nationalDefenseScience/userBase/getUserInfo");
    }

    /**
     *
     * @param token:请求头中的令牌
     * @param upPassword:用户需要更改的密码
     * @return 自定义返回值
     */
    @ApiOperation("修改当前登录用户密码")
    @PutMapping("/upUserPassword")
    public Result upUserPassword(@RequestHeader(value = "Token")String token,@RequestParam(value = "UpPassword") String upPassword){
        return userService.upUserPassword(token,upPassword,"/nationalDefenseScience/userBase/upUserPassword");
    }

    /**
     * 测试
     * @return 自定义返回值
     */
    @ApiOperation("测试")
    @GetMapping("/test")
    public Result getTest(){
        System.out.print(":");
        return new Result().result200("成功","nn");
    }

}
