package com.inet.utils;

import com.inet.entity.vo.UserVO;

/**
 * @program: springboot
 * @description: 管理权限的工具类
 * @author: xiaotugou
 * @create: 2021-01-05 15:55
 **/
public class PermissionUtil {

    /**
     * 用户权限常量
     */
    public static final String ROLE_USER = "ROLE_USER";
    public static final String ROLE_ADMINISTRATOR = "ROLE_ADMINISTRATOR";
    public static final String ROLE_ADMIN = "ROLE_ADMIN";

    /**
     * 判断用户是否是普通用户，管理员，超级管理员
     *
     * @param userVO:含有用户角色信息的用户信息对象
     * @return 如果是超级管理员或者管理员或者普通用户，那就返回true
     */
    public static Boolean allPermission(UserVO userVO) {
        String userRole = userVO.getUserRole();
        //将用户角色与拥有操作权限的角色名作比较，如果满足，那就返回true
        return ROLE_ADMIN.equals(userRole) || ROLE_USER.equals(userRole) || ROLE_ADMINISTRATOR.equals(userRole);
    }

    /**
     * 判断用户是否是管理员，超级管理员
     *
     * @param userVO:含有用户角色信息的用户信息对象
     * @return 如果是超级管理员或者管理员或者普通用户，那就返回true
     */
    public static Boolean adminPermission(UserVO userVO) {
        String userRole = userVO.getUserRole();
        //将用户角色与拥有操作权限的角色名作比较，如果满足，那就返回true
        return ROLE_ADMIN.equals(userRole) || ROLE_ADMINISTRATOR.equals(userRole);
    }

    /**
     * 判断用户是否是超级管理员
     *
     * @param userVO:含有用户角色信息的用户信息对象
     * @return 如果是超级管理员或者管理员或者普通用户，那就返回true
     */
    public static Boolean administratorPermission(UserVO userVO) {
        String userRole = userVO.getUserRole();
        //将用户角色与拥有操作权限的角色名作比较，如果满足，那就返回true
        return ROLE_ADMIN.equals(userRole) || ROLE_ADMINISTRATOR.equals(userRole);
    }

}