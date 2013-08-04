/**
 * Copyright(c) 2013 ShenZhen ChuangFa Technology Co., Ltd.
 * All rights reserved.
 * Created on  Apr 28, 2013  10:58:25 AM
 */
package com.chuangfa.action.user;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.chuangfa.BaseAction;
import com.chuangfa.LoginedUser;
import com.chuangfa.entity.UserEntity;
import com.chuangfa.service.user.UserService;
import com.chuangfa.service.user.impl.UserServiceImpl;
import com.opensymphony.xwork2.validator.annotations.RegexFieldValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.Validations;
import com.opensymphony.xwork2.validator.annotations.ValidatorType;

/**
 * 用户
 * 
 * @author ChuangFa
 */
@SuppressWarnings("serial")
@Controller
@Scope("prototype")
@ParentPackage("chuangfa-default")
@Namespace("/userManager")
@Results( { @Result(name = "success", type = "dispatcher", location = "/index.jsp") })
public class UserAction extends BaseAction<UserEntity> {
    /**`
     * userService
     */
    @Resource
    private UserService userService;
    /**
     * 登录的用户
     */
    private LoginedUser loginInfo;

    /**
     * base
     * 
     * @throws Exception
     *             exc
     */
    @Action("/user")
    public String execute() throws Exception {
        // TODO Auto-generated method stub
        return INPUT;
    }

    /**
     * 查询
     * 
     * @throws Exception
     *             所有不能处理的异常
     */
    public String query() throws Exception {
        userService.query(cloudContext);
        return JSON;
    }

    /**
     * 登录
     * 
     * @throws Exception
     *             所有不能处理的异常
     */
    public String login() throws Exception {
        userService.login(cloudContext);
        return SUCCESS;
    }

    /**
     * 注册
     * 
     * @throws Exception
     *             所有不能处理的异常
     */
    @Validations(requiredStrings = { @RequiredStringValidator(type = ValidatorType.SIMPLE, fieldName = "userVO.userEntity.username", message = "用户名必须存在") }, regexFields = { @RegexFieldValidator(type = ValidatorType.SIMPLE, fieldName = "userVO.userEntity.username", expression = "[\\w\\-]{4,12}", message = "用户名必须是4-12的字符") })
    public String register() throws Exception {
        userService.register(cloudContext);
        return JSON;
    }

    /**
     * 注销
     * 
     * @throws Exception
     *             所有不能处理的异常
     */
    public String logout() throws Exception {
        userService.logout(cloudContext);
        return JSON;
    }

    /**
     * 初始化注册信息
     * 
     * @return
     * @throws Exception
     *             exc
     */
    public String initRegister() throws Exception {
        userService.initRegister();
        return SUCCESS;
    }

    public void setUserService(UserServiceImpl userService) {
        this.userService = userService;
    }

    public LoginedUser getLoginInfo() {
        return loginInfo;
    }

    public void setLoginInfo(LoginedUser loginInfo) {
        this.loginInfo = loginInfo;
    }

}
