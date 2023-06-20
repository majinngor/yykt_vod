package com.yy.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.yy.model.user.UserInfo;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author majinngor
 * @since 2023-06-12
 */
public interface UserInfoService extends IService<UserInfo> {

    UserInfo getByOpenid(String openId);
}
