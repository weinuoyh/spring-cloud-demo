package com.mapper;

import com.entity.TbOrder;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 订单表 Mapper 接口
 * </p>
 *
 * @author sxt
 * @since 2020-04-21
 */
@Mapper
public interface TbOrderMapper extends BaseMapper<TbOrder> {

}
