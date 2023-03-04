package com.xxxx.server.pojo;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/*用户登录实体类*/
@Data
// 此注解会生成equals(Object other) 和 hashCode()方法。
@EqualsAndHashCode(callSuper = false)
// 存取器 用于配置getter和setter方法的生成结果
@Accessors(chain = true)
// 描述返回对象的意义
@ApiModel(value = "AdminLogin对象",description = "")
public class AdminLoginParam {
    // 添加和操作模型属性的数据  redOnly:是否为必传参数
    @ApiModelProperty(value = "用户名",required = true)
    private String username;
    @ApiModelProperty(value = "密码",required = true)
    private String password;
    @ApiModelProperty(value = "验证码",required = true)
    private String code;

}
