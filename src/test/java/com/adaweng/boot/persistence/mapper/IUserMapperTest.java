//package com.adaweng.boot.persistence.mapper;
//
//import com.adaweng.boot.Application;
//import com.adaweng.boot.entity.User;
//import org.junit.After;
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mybatis.spring.annotation.MapperScan;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.context.web.WebAppConfiguration;
//
//import javax.annotation.Resource;
//import java.util.Date;
//import java.util.List;
//
//import static org.junit.Assert.*;
//
///**
// * Created by eyaweng on 8/30/2017.
// */
//
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = Application.class)
//@WebAppConfiguration
//public class IUserMapperTest {
//    @Autowired
//    private IUserMapper userMapper;
//
//    @Before
//    public void setUp() throws Exception {
//
//    }
//
//    @After
//    public void tearDown() throws Exception {
//
//    }
//
//    @Test
//    public void testGetUsers() throws Exception {
//
//    }
//
//    @Test
//    public void testGetUserByName() throws Exception {
//        User user = new User();
//        user.setName("Ada Weng");
//        List<User> users = userMapper.getUserByName(user.getName());
//        Assert.assertEquals(users.get(0).getName(), user.getName());
//
//        String name = "Ada Weng";
//        Assert.assertEquals(name, userMapper.getUserByName(user.getName()).get(0).getName());
//    }
//
//    @Test
//    public void  testDelete() throws Exception {
//        User user = new User();
//        user.setName("Ada Temp");
//        user.setAddress("Xi'an Temp");
//        Long saveCount = userMapper.save(user);
//        Assert.assertNotNull("insert user number is", saveCount);
//
//        Long deleteCount = userMapper.delete(2L);
//        Assert.assertNotNull("delete user number is ", deleteCount);
//
//    }
//}