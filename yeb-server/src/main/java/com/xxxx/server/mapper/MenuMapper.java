package com.xxxx.server.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xxxx.server.pojo.Menu;
import org.springframework.context.annotation.Bean;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zhoubin
 * @since 2021-12-17
 */
public interface MenuMapper extends BaseMapper<Menu> {

    /*根据用户id查询菜单列表*/
    List<Menu> getMenusByAdminId(Integer id);

    /*根据角色获取菜单列表*/
    List<Menu> getMenusWithRole();

    /*查询所有菜单*/
    List<Menu> getAllMenus();
}
