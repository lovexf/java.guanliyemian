package com.xxxx.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xxxx.server.pojo.Department;
import com.xxxx.server.pojo.RespBean;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhoubin
 * @since 2021-12-17
 */
public interface IDepartmentService extends IService<Department> {

    //获取所有部门
    List<Department> getAllDepartments();

    //添加部门
    RespBean addDep(Department dep);

    //删除部门
    RespBean deleteDep(Integer id);
}
