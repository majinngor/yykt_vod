package com.yy.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yy.model.user.UserLoginLog;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 用户登陆记录表 Mapper 接口
 * </p>
 *
 * @author majinngor
 * @since 2023-06-12
 */
@Repository
public interface UserLoginLogMapper extends BaseMapper<UserLoginLog> {

}
