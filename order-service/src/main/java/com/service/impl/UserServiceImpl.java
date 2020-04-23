package com.service.impl;

import com.entity.User;
import com.mapper.UserMapper;
import com.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author sxt
 * @since 2020-04-23
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
@Autowired
    UserMapper userMapper;
    @Override
    public User getByName(String name) {
        return userMapper.getByName( name);
    }
}
