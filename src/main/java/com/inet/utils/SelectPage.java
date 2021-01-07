package com.inet.utils;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * selectPage：用来快速查询页面和多少条信息的工具类
 *             List<T> selectList：用来接收查询到记录的集合
 *             Integer page：用来接收前端查询的是第几页
 *             Integer cont：用来查询前端要求一页要多少条记录
 * @author Administrator
 */
public class SelectPage {

//    public static <T> Result selectPage(List<T> selectList,Integer page,Integer cont){
//        //初始化总页数为0
//        int pageamount = 0;
//        //判断每页条数是否为0，如果为0那就直接返回错误
//        if (cont == 0) {
//            return new Result(null, "条目输入错误", 104);
//        }
//        //用来存分页查询到的照片墙对象
//        List<T> lists = new ArrayList<>();
//
//        //如果查询到的记录条数整除每页条数等于零，也就是说如果每一条记录都刚好被每一页分配完了，没有多出来的记录
//        if (selectList.size() % cont == 0) {
//            //集合除以每条页面的记录条数就等于一共的页面整数
//            pageamount = selectList.size() / cont;
//            //判断页数是否超过了总页数
//            if (page > pageamount) {
//                return new Result(null, "页数有误", 104);
//            }
//            //将分页查询到的对象赋值给集合
//            for (int i = (page - 1) * cont; i < page*cont; i++) {
//                lists.add(selectList.get(i));
//            }
//        }
//        //如果记录总数不够一页来分配
//        else if (selectList.size() / cont < 1) {
//            //让总页数等于1
//            pageamount = 1;
//            //判断页数是否超过了总页数
//            if (page > pageamount) {
//                return new Result(null, "页数有误", 104);
//            }
//            //直接就一整页，让lists等于selectList 到后面直接返回lists就等于是直接返回了selectList
//            lists=selectList;
//        }
//        //如果记录总数比一页多，而且没有填满最后一页的情况
//        else {
//            //页数就等于整除后拿到的页数加上没有满记录的那一页 就是总页数
//            pageamount = selectList.size() / cont + 1;
//            //判断页数是否超过了总页数
//            if (page > pageamount) {
//                return new Result(null, "页数有误", 104);
//            }
//            //判断前端的第几页是否等于最后一页
//            else if(page == pageamount){
//                //如果是最后一页，那就将最后一页的对象的对象给lists，这样不会有空指针异常
//                for (int i =(page-1) * cont; i<selectList.size();i++){
//                    lists.add(selectList.get(i));
//                }
//            }
//            //如果用户不是点击了最后一页的话 那就跟普通情况一样
//            else{
//                for (int i = (page - 1) * cont; i < page*cont; i++) {
//                    lists.add(selectList.get(i));
//                }
//            }
//
//        }
//        //map用来存放返回的总页数和当前页面的照片墙对象
//        Map<String, Object> map = new HashMap<>(2);
//
//        //总页数存进map
//        map.put("pageamount", pageamount);
//
//        //把按页查询到的照片墙对象存入map
//        map.put("objectList",lists);
//
//        return  new Result(map,"获取成功",100);
//    }
}
