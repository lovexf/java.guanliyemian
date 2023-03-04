package com.xxxx.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xxxx.server.pojo.Menu;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhoubin
 * @since 2021-12-17
 */
public interface IMenuService extends IService<Menu> {

    /*根据用户id查询菜单*/
    List<Menu> getMenusByAdminId();

    /*根据角色获取菜单列表*/
    List<Menu> getMenusWithRole();

    /*查询所有菜单*/
    List<Menu> getAllMenus();
}
