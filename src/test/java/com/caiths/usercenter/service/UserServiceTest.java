package com.caiths.usercenter.service;

import com.caiths.usercenter.model.domain.User;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * 用户服务测试
 *
 * @author caiths
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Resource
    private UserService userService;

    @Test
    public void testAddUser() {
        User user = new User();
        user.setUsername("miao");
        user.setUserAccount("123");
        user.setAvatarUrl("https://d-ssl.dtstatic.com/uploads/blog/202402/17/oVS75dBGtgWPOMG.thumb.300_300_c.jpg_webp");
        user.setGender(0);
        user.setUserPassword("xxx");
        user.setPhone("123");
        user.setEmail("456");
        boolean result = userService.save(user);
        System.out.println(user.getId());
        Assertions.assertTrue(result); // 断言


    }

    @Test
    public void userRegister() {
        String userAccount = "caiths";
        String userPassword = "";
        String checkPassword = "123456";
        long result = userService.userRegister(userAccount, userPassword, checkPassword);
        Assertions.assertEquals(-1, result);
        userAccount = "yu";
        result = userService.userRegister(userAccount, userPassword, checkPassword);
        Assertions.assertEquals(-1, result);
        userAccount = "caiths";
        userPassword = "123456";
        result = userService.userRegister(userAccount, userPassword, checkPassword);
        Assertions.assertEquals(-1, result);
        userAccount = "cai ths";
        userPassword = "12345678";
        result = userService.userRegister(userAccount, userPassword, checkPassword);
        Assertions.assertEquals(-1, result);
        checkPassword = "123456789";
        result = userService.userRegister(userAccount, userPassword, checkPassword);
        Assertions.assertEquals(-1, result);
        userAccount = "caiDog";
        checkPassword = "12345678";
        result = userService.userRegister(userAccount, userPassword, checkPassword);
        Assertions.assertEquals(-1, result);
        userAccount = "caiths1";
        result = userService.userRegister(userAccount, userPassword, checkPassword);
        Assertions.assertTrue(result > 0);

    }
}
