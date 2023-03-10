package com.xxxx.server.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xxxx.server.pojo.MenuRole;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zhoubin
 * @since 2021-12-17
 */
public interface MenuRoleMapper extends BaseMapper<MenuRole> {

    //更新角色菜单
    Integer insertRecord(@Param("rid") Integer rid, @Param("mids") Integer[] mids);
}
