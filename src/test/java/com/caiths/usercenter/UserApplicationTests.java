package com.caiths.usercenter;

import com.baomidou.mybatisplus.core.toolkit.Assert;
import com.caiths.usercenter.mapper.UserMapper;
import com.caiths.usercenter.model.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;


@SpringBootTest
class UserApplicationTests {
    @Resource
    private UserMapper userMapper;

    @Test
    void contextLoads() {
        System.out.println(("----- selectAll method test ------"));
        List<User> userList = userMapper.selectList(null);
        Assert.isTrue(5 == userList.size(), "");
        userList.forEach(System.out::println);
    }

}
