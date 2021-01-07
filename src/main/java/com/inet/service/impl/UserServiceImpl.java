package com.inet.service.impl;

import com.inet.entity.dto.RegisterDTO;
import com.inet.entity.po.RoleUser;
import com.inet.entity.po.User;
import com.inet.entity.po.UserPassword;
import com.inet.entity.vo.Result;
import com.inet.entity.vo.UserVO;
import com.inet.mapper.UserMapper;
import com.inet.service.UserService;
import com.inet.utils.BeanUtil;
import com.inet.utils.PermissionUtil;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @program: springboot
 * @description:
 * @author: xiaotugou
 * @create: 2021-01-03 20:18
 **/
@Service
public class UserServiceImpl implements UserService {

    /**
     * 自动注入mapper层操作对象
     */
    @Resource
    private UserMapper userMapper;

    /**
     * 自动注入的redis操作对象
     */
    @Resource
    private RedisTemplate<Object,Object> redisTemplate;

    /**
     * 时间格式
     */
    SimpleDateFormat simpleDateFormat= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     *
     * @param registerDTO:从控制层获取到的前端的数据对象
     * @param path:请求路径
     * @return 返回状态码200和注册成功
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public Result saveUser(RegisterDTO registerDTO,String path){
        //先查询是否存在相同用户名
        User getByUsername =userMapper.getByUsername(registerDTO.getUsername());
        if (getByUsername != null){
            return new Result().result403("用户名已存在", path);
        }
        //将从请求获取到的属性赋值给user对象
        User user =BeanUtil.copy(registerDTO,User.class);
        //使用uuid生成随机id
        user.setId(UUID.randomUUID().toString());
        //设置默认头像
        user.setPhotoPath("http://www.woshitugou.cn/images/chart/6856b646-b4d9-4c1e-b8bb-2d97c40b5959.png");
        //将从请求获取到的属性赋值给userPassword对象
        UserPassword userPassword =BeanUtil.copy(registerDTO,UserPassword.class);
        //使用uuid生成随机id
        userPassword.setId(UUID.randomUUID().toString());
        //用户角色关系表对象用来插入用户角色关系信息
        RoleUser roleUser = new RoleUser();
        //设置id
        roleUser.setId(UUID.randomUUID().toString());
        //获取注册用户的id
        roleUser.setUserId(user.getId());
        //查询数据库获取到普通用户对应的角色的id并存到用户角色关系实体类中
        roleUser.setRoleId(userMapper.getRoleIdByRoleName("ROLE_USER"));
        //如果用户信息，用户账号密码信息，角色信息插入都成功，返回注册成功
        if (userMapper.saveUser(user) && userMapper.saveUserPassword(userPassword) && userMapper.saveRoleUser(roleUser)){
            return new Result().result200("注册成功", path);
        }
        return new Result().result500("未知错误", path);
    }

    /**
     * 用户登录
     * @param upd:存储着用户账号和密码的实体类
     * @param path:请求路径
     * @return 返回token
     */
    @Override
    public Result getUser(UserPassword upd,String path) {
        //查询数据库是否存在此账号密码的用户
        UserPassword userPassword = userMapper.getUserByPassword(upd);
        //如果查询结果不为空，那就是登录成功
        if (userPassword != null){
            //通过用户名去查询用户信息
            User user = userMapper.getUserByUsername(userPassword.getUsername());
            //将用户信息对象的属性拷贝给需要存储的用户信息对象
            UserVO userVO = BeanUtil.copy(user,UserVO.class);
            //将用户密码存储到用户信息对象
            userVO.setPassword(userPassword.getPassword());
            //将用户创建时间以yyyy-MM-dd HH:mm:ss格式存储到用户信息对象
            userVO.setGmtCreate(simpleDateFormat.format(user.getGmtCreate()));
            //将用户修改时间以yyyy-MM-dd HH:mm:ss格式存储到用户信息对象
            userVO.setGmtModified(simpleDateFormat.format(user.getGmtModified()));
            //将角色类型存储到用户信息对象
            userVO.setUserRole(userMapper.getRoleNameByRoleId(userMapper.getRoleIdByUserId(user.getId())));
            //使用UUID生成token
            String token = UUID.randomUUID().toString();
            //将token作为key，value为用户信息对象存入redis，并设置过期时长为7天
            redisTemplate.opsForValue().set(token,userVO, Duration.ofMinutes(10080L));
            //返回登录成功，并将token一并返回
            return new Result().result200(token, path);
        }else{
            return new Result().result403("密码错误", path);
        }
    }

    /**
     * 获取用户信息,通过token从redis中获取用户信息
     * @param token:从请求头中获取到的token
     * @param path:请求路径
     * @return 自定义返回值
     */
    @Override
    public Result getUserInfo(String token,String path) {
        //通过token获取redis中存储的用户信息对象
        UserVO userVO = (UserVO) redisTemplate.opsForValue().get(token);
        //如果获取对象不为空，表示当前用户正在登录
        if (userVO!=null){
            //使用工具类获取是否具有操作权限
            if (PermissionUtil.allPermission(userVO)){
                //有操作权限就将用户信息返回给前端
                return new Result().result200(userVO,path);
            }else {
                //权限不足，将权限不足信息返回给前端
                return new Result().result401("权限不足",path);
            }
        }
        return new Result().result403("未登录",path);
    }

    /**
     * 修改密码
     * @param token:接收的客服端请求的信息对象
     * @param upPassword:用户更新后的密码
     * @param path:请求路径
     * @return 自定义返回值
     */
    @Override
    public Result upUserPassword(String token, String upPassword, String path) {
        //通过token获取redis中存储的用户信息对象
        UserVO userVO = (UserVO) redisTemplate.opsForValue().get(token);
        //判断是否登录成功
        if (userVO!=null){
            //获取是否拥有操作权限
            if (PermissionUtil.allPermission(userVO)){
                //如果拥有权限，判断用户需要更改的密码是否和原先密码相同
                if (upPassword.equals(userVO.getPassword())){
                    //密码相同 直接返回密码不能与原密码相同给前端
                    return new Result().result500("密码不能与原密码相同",path);
                }
                //将需要修改的密码更新至数据库
                if (userMapper.upUserPassword(userVO.getUsername(),upPassword)){
                    //设置用户信息对象的密码为新密码
                    userVO.setPassword(upPassword);
                    //将更新过的用户信息对象存入redis中，并设置时长为7天
                    redisTemplate.opsForValue().set(token,userVO,Duration.ofMinutes(10080L));
                    //将修改完密码的信息返回给前端
                    return new Result().result200("修改密码成功",path);
                }
                return new Result().result500("未知错误,修改密码失败",path);
            }else {
                //没有操作权限就返回权限不足
                return new Result().result401("权限不足",path);
            }
        }
        //redis中没有相应token为key的值，等同未登录,将为登录返回给前端
        return new Result().result403("未登录",path);
    }
}