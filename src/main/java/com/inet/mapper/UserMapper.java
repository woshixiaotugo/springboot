package com.inet.mapper;

import com.inet.entity.po.RoleUser;
import com.inet.entity.po.User;
import com.inet.entity.po.UserPassword;

/**
 * @author Administrator
 */
public interface UserMapper {
    /**
     * 注册插入用户基础信息到数据库
     * @param user:存储用户基础信息
     * @return 判断是否插入成功
     */
    Boolean saveUser(User user);

    /**
     * 注册插入用户账号密码到数据库
     * @param userPassword:存储用户账号密码对象
     * @return 判断是否插入成功
     */
    Boolean saveUserPassword(UserPassword userPassword);

    /**
     * 通过用户名查询是否已经存在用户名
     * @param username:用户名
     * @return 查询到的对象
     */
    User getByUsername(String username);

    /**
     * 通过账号密码查询数据库得知账号密码是否正确
     * @param username:用户名
     * @param password:用户密码
     * @return 查询到的用户密码关系表对象
     */
    UserPassword getUserByPassword(String username, String password);

    /**
     * 通过用户名查询数据库获取用户信息
     * @param username:用户名
     * @return 查询到用户信息
     */
    User getUserByUsername(String username);

    /**
     * 插入用户角色的关系到用户角色关系表
     * @param roleUser:角色关系对象
     * @return 判断是否插入成功
     */
    Boolean saveRoleUser(RoleUser roleUser);

    /**
     * 通过角色名获取角色id
     * @param roleName:角色名
     * @return 角色id
     */
    String getRoleIdByRoleName(String roleName);

    /**
     * 通过用户id获取角色id
     * @param userId:用户id
     * @return 角色id
     */
    String getRoleIdByUserId(String userId);

    /**
     * 通过角色id获取对应的角色名
     * @param roleNameByRoleId:角色id
     * @return 角色名
     */
    String getRoleNameByRoleId(String roleNameByRoleId);

    /**
     * 通过用户名去修改用户密码
     * @param username:用户名
     * @param upPassword:用户密码
     * @return 是否修改成功
     */
    Boolean upUserPassword(String username, String upPassword);
}
