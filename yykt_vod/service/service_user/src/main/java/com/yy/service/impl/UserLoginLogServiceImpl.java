package com.yy.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yy.mapper.UserLoginLogMapper;
import com.yy.model.user.UserLoginLog;
import com.yy.service.UserLoginLogService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户登陆记录表 服务实现类
 * </p>
 *
 * @author majinngor
 * @since 2023-06-12
 */
@Service
public class UserLoginLogServiceImpl extends ServiceImpl<UserLoginLogMapper, UserLoginLog> implements UserLoginLogService {

}
