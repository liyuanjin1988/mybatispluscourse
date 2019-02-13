package com.bjlemon;

import static org.junit.Assert.assertTrue;

import com.baomidou.mybatisplus.core.conditions.query.EmptyWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bjlemon.domain.User;
import com.bjlemon.mapper.UserMapper;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.junit.Test;
import org.omg.PortableInterceptor.USER_EXCEPTION;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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
        UserMapper userMapper = ioc.getBean(UserMapper.class);
        User user = new User();
        user.setName("admin");
        user.setEmail("12345@163.com");
        user.setIdCard("505954446646");

        int intRow = userMapper.insert(user);
        System.out.println(intRow);
        System.out.println(user);
    }

    @Test
    public void testDeleteById() {
        UserMapper userMapper = ioc.getBean(UserMapper.class);
        int row = userMapper.deleteById("601605ca5523d87e79b19336d2dd6edb");

        System.out.println(row);
    }

    @Test
    public void testDeleteByMap() {
        UserMapper userMapper = ioc.getBean(UserMapper.class);

        Map<String, Object> map = new HashMap<>();

        // key: 列名 value: 筛选值
        map.put("name", "张学友");
        map.put("card", null);

        int row = userMapper.deleteByMap(map);
        System.out.println(row);
    }

    @Test
    public void testDeleteBatchIds() {
        UserMapper userMapper = ioc.getBean(UserMapper.class);
        List<String> ids = new ArrayList<>();

        ids.add("0dc4250b99643b868c1fc9c4f6d901f8");
        ids.add("835b8963de5a2cd75751505fa247d5a0");

        int row = userMapper.deleteBatchIds(ids);
        System.out.println(row);
    }

    @Test
    public void testUpdateById() {
        UserMapper userMapper = ioc.getBean(UserMapper.class);

        User user = new User();
        user.setId("4");
        user.setEmail("");
        user.setIdCard("512241445x");

        int row = userMapper.updateById(user);
        System.out.println(row);
    }

    @Test
    public void testSelectById() {
        UserMapper userMapper = ioc.getBean(UserMapper.class);
        User user = userMapper.selectById("126");
        System.out.println(user);
    }

    @Test
    public void testSelectList() {
        UserMapper userMapper = ioc.getBean(UserMapper.class);
        List<User> users = userMapper.selectList(null);
        System.out.println(users);

    }

    @Test
    public void testSelectBatchIds() {
        UserMapper userMapper = ioc.getBean(UserMapper.class);
        List<String> ids = new ArrayList<>();

        ids.add("120");
        ids.add("126");

        List<User> users = userMapper.selectBatchIds(ids);
        System.out.println(users);
    }

    @Test
    public void testSelectByMap() {
        UserMapper userMapper = ioc.getBean(UserMapper.class);
        Map<String, Object> map = new HashMap<>();

        map.put("name", "黎明");
        map.put("card", null);

        List<User> users = userMapper.selectByMap(map);
        System.out.println(users);

    }

    @Test
    public void testDeleteByWarpper() {
        UserMapper userMapper = ioc.getBean(UserMapper.class);
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();

        // .like("email", "@");
        // 条件为列名,非属性名(名字叫 黎明, 同时 邮箱包含@)
        QueryWrapper<User> queryWrapper = userQueryWrapper.eq("name", "李宁").and(item -> item.like("email", "@"));
        int row = userMapper.delete(queryWrapper);

        System.out.println(row);
    }

    @Test
    public void testUpdateByWrapper() {
        UserMapper userMapper = ioc.getBean(UserMapper.class);
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();

        User user = new User();
        user.setIdCard("500XX");

        userQueryWrapper.gt("id", 1).likeLeft("email", "163.com");

        int row = userMapper.update(user, userQueryWrapper);

        System.out.println(row);
    }

    @Test
    public void testQueryByWrapper() {
        UserMapper userMapper = ioc.getBean(UserMapper.class);
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();

        QueryWrapper<User> queryWrapper = userQueryWrapper.eq("name", "刘德华").or().eq("card", "123");

        User user = userMapper.selectOne(queryWrapper);

        System.out.println(user);
    }

    @Test
    public void testCount() {
        UserMapper userMapper = ioc.getBean(UserMapper.class);
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();

        QueryWrapper<User> queryWrapper = userQueryWrapper.like("email", "@qq.com");

        Integer count = userMapper.selectCount(queryWrapper);

        System.out.println(count);
    }

    @Test
    public void testQueryListByWrapper() {
        UserMapper userMapper = ioc.getBean(UserMapper.class);
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();

        userQueryWrapper.between("age", 20, 30).eq("sex", "男");

        List<User> userList = userMapper.selectList(userQueryWrapper);

        System.out.println(userList);
    }


    @Test
    public void testPage() {
        UserMapper userMapper = ioc.getBean(UserMapper.class);

        Page<User> page = new Page<>(1, 3);
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.gt("age", 20);


        IPage<User> userIPage = userMapper.selectPage(page, userQueryWrapper);

        System.out.println(userIPage.getRecords());
        System.out.println("当前页:" + userIPage.getCurrent());
        System.out.println("每页记录数:" + userIPage.getSize());
        System.out.println("总页数:" + userIPage.getPages());
        System.out.println("总记录数:" + userIPage.getTotal());
    }


}
