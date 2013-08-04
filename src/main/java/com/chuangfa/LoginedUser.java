/**
 * Copyright(c) 2012 ShenZhen ChuangFa Technology Co., Ltd.
 * All rights reserved.
 * Created on  Nov 14, 2012  3:14:34 PM
 */
package com.chuangfa;

import java.util.Date;

/**
 * 已经登录的用户
 * 
 * @author xgj
 * 
 */
public class LoginedUser {
    /**
     * 基本信息
     */
    private Integer id;
    /**
     * 用户名
     */
    private String username;
    /**
     * 真实姓名
     */
    private String realname;
    /**
     * 最后一次登陆时间
     */
    private Date lastLoginTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    /**
     * 是否拥有某个权限
     */
    public Boolean containRights(String url) {
        return true;

    }

    /**
     * 是否拥有某个模块
     */
    public Boolean containModule(String url) {
        return true;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }
}
