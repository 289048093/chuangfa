/**
 * Copyright(c) 2013 ShenZhen ChuangFa Technology Co., Ltd.
 * All rights reserved.
 * Created on  Apr 27, 2013  5:53:10 PM
 */
package com.chuangfa.dao;

import org.springframework.stereotype.Repository;

import com.chuangfa.BaseDAO;
import com.chuangfa.PropertyManager;
import com.chuangfa.entity.UserEntity;
import com.chuangfa.util.ProjectUtil;
import com.chuangfa.util.StringUtil;

/**
 * @author ChuangFa
 */
@Repository("userDAO")
public final class UserDAO extends BaseDAO {

    public UserEntity testingUsernameAndPassword(String username, String password) throws Exception {
        String md5pwd = StringUtil.encrypt(username, password);
        UserEntity user = PropertyManager.getUser();
        return (user.getUsername().equals(username) && user.getPassword().equals(md5pwd)) ? user : null;
    }

    public void update(UserEntity user) throws Exception {
        UserEntity oldUser = PropertyManager.getUser();
        oldUser.setPassword(user.getPassword());
        oldUser.setLastLoginTime(user.getLastLoginTime());
        ProjectUtil.writeObject2File(oldUser, UserEntity.class);
    }
    
}
