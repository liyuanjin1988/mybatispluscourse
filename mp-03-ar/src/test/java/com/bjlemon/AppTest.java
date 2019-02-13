package com.bjlemon;

import static org.junit.Assert.assertTrue;

import com.baomidou.mybatisplus.core.conditions.query.EmptyWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bjlemon.domain.User;
import com.bjlemon.mapper.UserMapper;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.junit.Test;
import org.omg.PortableInterceptor.USER_EXCEPTION;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Unit test for simple App.
 */
public class AppTest {

    static ClassPathXmlApplicationContext ioc = null;

    static {
        ioc = new ClassPathXmlApplicationContext("application.xml");
    }

    @Test
    public void testInsert() {
        User user = new User();
        user.setName("张三丰");
        user.setIdCard("210623198810210012");
        user.setEmail("zsf@163.com");
        user.setAge(88);
        user.setSex("男");

        boolean isOk = user.insert();

        System.out.println(isOk);
    }

    @Test
    public void testUpdate() {
        User user = new User();
        user.setId(127);

        user.setEmail("1555322@qq.com");

        boolean isOk = user.updateById();

        System.out.println(isOk);

    }

    @Test
    public void testQuery() {
        User user = new User();
        user.setId(126);

        User model = (User) user.selectById();

        System.out.println(model);
    }


    @Test
    public void testQueryList() {
        User user = new User();

        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.gt("age", 20).orderByDesc("age");

        List<User> userList = user.selectList(queryWrapper);

        System.out.println(userList);
    }

    @Test
    public void testQueryAll() {
        User user = new User();
        List<User> userList = user.selectAll();

        System.out.println(userList);
    }

    @Test
    public void testQueryOne() {
        User user = new User();

        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name", "刘德华");

        User userResult = (User) user.selectOne(queryWrapper);

        System.out.println(userResult);
    }

    @Test
    public void testQueryCount() {
        User user = new User();

        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("sex", "男");

        Integer count = user.selectCount(queryWrapper);

        System.out.println(count);

    }

    @Test
    public void testQueryPage() {
        User user = new User();

        Page page = new Page(1, 2);
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();

        queryWrapper.between("age", 20, 50).eq("sex", '男');

        IPage iPage = user.selectPage(page, queryWrapper);

        System.out.println("查询的数据:" + iPage.getRecords());
        System.out.println("每页大小:" + iPage.getSize());
        System.out.println("当前的页码:" + iPage.getCurrent());
        System.out.println("总页数:" + iPage.getPages());
        System.out.println("总记录数:" + iPage.getTotal());

    }

    @Test
    public void testDelete() {
        User user = new User();
        // user.setId(120);

        // boolean isOk = user.deleteById();
        boolean isOk = user.deleteById(120);
        System.out.println(isOk);
    }

    @Test
    public void testDeleteByWrapper() {
        User user = new User();

        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.lt("age", 20);

        boolean isOk = user.delete(queryWrapper);

        System.out.println(isOk);
    }


}
