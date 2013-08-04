/**
 * Copyright(c) 2013 ShenZhen ChuangFa Technology Co., Ltd.
 * All rights reserved.
 * Created on  Apr 28, 2013  10:58:25 AM
 */
package com.chuangfa.service.user.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.chuangfa.BaseService;
import com.chuangfa.CloudContext;
import com.chuangfa.dao.UserDAO;
import com.chuangfa.entity.UserEntity;
import com.chuangfa.service.user.UserService;

/**
 * 用户service
 * 
 * @author ChuangFa
 */
@SuppressWarnings("unused")
@Service("userService")
public class UserServiceImpl extends BaseService implements UserService {
    /**
     * userDAO
     */
    @Resource
    private UserDAO userDAO;

    /**
     * 注销
     * 
     * @param cloudContext
     * @exception exc
     */
    public void logout(CloudContext<UserEntity> cloudContext) {
    }

    /**
     * 登陆
     * 
     * @return
     * @throws Exception
     */
    public void login(CloudContext<UserEntity> cloudContext){
    }

    /**
     * 注册
     * 
     * @return
     * @throws Exception
     */
    public void register(CloudContext<UserEntity> cloudContext){
    }

    /**
     * @param cloudContext
     */
    public void query(CloudContext<UserEntity> cloudContext) {
        // TODO Auto-generated method stub

    }

    /**
     * 找回密码
     */
    public void retrievePwd(CloudContext<UserEntity> cloudContext) {
        // TODO Auto-generated method stub

    }

    /**
     * 
     */
    @Override
    public void initRegister() {
        // TODO Auto-generated method stub

    }
}
