package com.service;

import com.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author sxt
 * @since 2020-04-23
 */
public interface IUserService extends IService<User> {

    User getByName(String name);
}
