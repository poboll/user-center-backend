package com.caiths.usercenter.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.caiths.usercenter.model.domain.User;
import com.caiths.usercenter.service.UserService;
import com.caiths.usercenter.mapper.UserMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import javax.annotation.Resource;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 用户服务实现类
 *
* @author caiths
* @description 针对表【user(用户)】的数据库操作Service实现
* @createDate 2024-05-22 12:48:04
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public long userRegister(String userAccount, String userPassword, String checkPassword) {
        // 1.校验
        if (userAccount == null || userPassword == null || checkPassword == null) {
            return -1;
        }
        if (userAccount.length() < 4) {
            return -1;
        }
        if (userPassword.length() < 8 || checkPassword.length() < 8) {
            return -1;
        }
        // 账户不能包含特殊字符
        String validPattern = "^[a-zA-Z0-9_]+$";
        Matcher matcher = Pattern.compile(validPattern).matcher(userAccount);
        if (!matcher.find()) {
            return -1;
        }
        // 密码和校验密码相同
        if (!userPassword.equals(checkPassword)) {
            return -1;
        }
        // 账户不能重复
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("userAccount", userAccount);
//        long count = this.count(queryWrapper);
        long count = userMapper.selectCount(queryWrapper);
        if (count > 0) {
            return -1;
        }
        // 2.加密
        final String SALT = "caiths"; // 盐（非对称加密）：混淆
        String encryPassword = DigestUtils.md5DigestAsHex((SALT + userPassword).getBytes());
        // 3.插入数据
        User user = new User();
        user.setUserAccount(userAccount);
        user.setUserPassword(encryPassword);
        this.save(user);
        boolean saveResult = this.save(user);
        if (!saveResult) {
            return -1;
        }
        return user.getId();
    }
}




