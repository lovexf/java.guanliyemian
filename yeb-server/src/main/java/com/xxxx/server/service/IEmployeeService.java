package com.xxxx.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xxxx.server.pojo.Employee;
import com.xxxx.server.pojo.Menu;
import com.xxxx.server.pojo.RespBean;
import com.xxxx.server.pojo.RespPageBean;
import io.swagger.models.auth.In;

import java.time.LocalDate;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhoubin
 * @since 2021-12-17
 */
public interface IEmployeeService extends IService<Employee> {

    /*获取所有员工(分页)*/
    RespPageBean getEmployeeByPage(Integer currentPage, Integer size, Employee employee, LocalDate[] beginDateScope);

    /*获取工号*/
    RespBean maxWorkID();

    /*添加员工*/
    RespBean addEmp(Employee employee);

    /*查询员工*/
    List<Employee> getEmployee(Integer id);

    /*获取所有员工账套*/
    RespPageBean getEmployeeWithSalary(Integer currentPage, Integer size);
}
