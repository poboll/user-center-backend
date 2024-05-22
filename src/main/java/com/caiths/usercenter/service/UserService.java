package com.caiths.usercenter.service;

import com.caiths.usercenter.model.domain.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 用户注释
 *
 * @param userAccount 用户账户
 * @param userPassword 用户密码
 * @param checkPassword 校验密码
 * @return 新用户
 * @author caiths
 * @description 针对表【user(用户)】的数据库操作Service
 * @createDate 2024-05-22 12:48:04
 */
public interface UserService extends IService<User> {

    long userRegister(String userAccount, String userPassword, String checkPassword);

}
