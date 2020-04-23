package com.mapper;

import com.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author sxt
 * @since 2020-04-23
 */
@Repository
public interface UserMapper extends BaseMapper<User> {

    User getByName(@Param("name") String name);
}
