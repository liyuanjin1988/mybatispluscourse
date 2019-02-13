package com.bjlemon;

import static org.junit.Assert.assertTrue;

import com.bjlemon.domain.User;
import com.bjlemon.mapper.UserMapper;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Unit test for simple App.
 */
public class AppTest {
    @Test
    public void testHello() {
        ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext("application.xml");
        UserMapper userMapper = ioc.getBean(UserMapper.class);

        User user01 = new User();
        // user01.setId(120);
        user01.setName("郭德纲");
        user01.setEmail("guodegang@163.com");
        user01.setIdCard("332342304fwaefaew");
        int row = userMapper.insert(user01);

        System.out.println(row);
    }
}
