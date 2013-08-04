/**
 * Copyright(c) 2013 ShenZhen ChuangFa Technology Co., Ltd.
 * All rights reserved.
 * Created on  Apr 28, 2013  10:58:25 AM
 */
package com.chuangfa.service.user;

import com.chuangfa.CloudContext;
import com.chuangfa.entity.UserEntity;

/**
 * userService 接口
 * 
 * @author ChuangFa
 */
public interface UserService {
    /**
     * 用户登录
     * 
     * @param cloudContext
     * @throws Exception
     *             异常
     */
    void login(CloudContext<UserEntity> cloudContext) throws Exception;

    /**
     * 用户注销
     * 
     * @param cloudContext
     * @throws Exception
     *             无法处理的异常
     */
    void logout(CloudContext<UserEntity> cloudContext) throws Exception;

    /**
     * 用户注册
     * 
     * @param cloudContext
     * @throws Exception
     *             无法处理的异常
     */
    void register(CloudContext<UserEntity> cloudContext) throws Exception;

    /**
     * 用户查询
     * 
     * @param cloudContext
     * @throws Exception
     *             无法处理的异常
     */
    void query(CloudContext<UserEntity> cloudContext) throws Exception;

    /**
     * 找回密码
     * 
     * @param cloudContext
     * @throws Exception
     *             无法处理的异常
     */
    void retrievePwd(CloudContext<UserEntity> cloudContext) throws Exception;

    /**
     * 初始化注册：初始化提示问题等信息
     * 
     * @param cloudContext
     * @throws Exception
     *             无法处理的异常
     */
    void initRegister() throws Exception;
}
