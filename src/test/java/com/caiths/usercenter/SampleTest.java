package com.caiths.usercenter;

import com.caiths.usercenter.mapper.UserMapper;
import com.caiths.usercenter.model.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SampleTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSelect() {
        System.out.println("----- selectAll method test ------");
        List<User> userList = userMapper.selectList(null);
        assertNotNull(userList, "User list should not be null");
        assertEquals(5, userList.size(), "User list size should be 5");
        userList.forEach(System.out::println);
    }
}
