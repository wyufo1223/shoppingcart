package com.adaweng.shoppingcart.mapper;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.adaweng.shoppingcart.entity.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {
	@Autowired
    private UserMapper userMapper;

	@Before
	public void setUp() throws Exception {
	}

	@Test
    public void testGetUserById() throws Exception {
    	 User user = new User();
         user.setId(1l);
         user.setNickName("Ada Weng");
         User user1 = userMapper.getUserById(user.getId());
         Assert.assertEquals(user1.getNickName(), user.getNickName());
    }

    @Test
    public void testGetUserByName() throws Exception {
        User user = new User();
        user.setUserName("Ada Weng");
        List<User> users = userMapper.getUserByName("Ada Weng");
        Assert.assertEquals(users.get(0).getUserName(), user.getUserName());

        String name = "Ada Weng";
        Assert.assertEquals(name, userMapper.getUserByName(user.getUserName()).get(0).getUserName());
    }

    @Test
    @Transactional
    public void  testDelete() throws Exception {
        User user = new User();
        user.setUserName("Ada Temp");
        user.setNickName("Ada Temp");
        Long saveCount = userMapper.save(user);
        Assert.assertNotNull("insert user number is", saveCount);

        Long deleteCount = userMapper.delete(2L);
        Assert.assertNotNull("delete user number is ", deleteCount);

    }

}
