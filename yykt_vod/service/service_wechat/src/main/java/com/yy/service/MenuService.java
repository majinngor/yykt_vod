package com.yy.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yy.model.wechat.Menu;
import com.yy.vo.wechat.MenuVo;

import java.util.List;

/**
 * <p>
 * 订单明细 订单明细 服务类
 * </p>
 *
 * @author majinngor
 * @since 2023-06-13
 */
public interface MenuService extends IService<Menu> {
    //获取全部菜单
    List<MenuVo> findMenuInfo();
    //获取一级菜单
    List<Menu> findOneMenuInfo();

    void syncMenu();

    void removeMenu();
}