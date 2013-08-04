/**
 * Copyright(c) 2013 ShenZhen ChuangFa Technology Co., Ltd.
 * All rights reserved.
 * Created on  Apr 27, 2013  5:53:10 PM
 */
package com.chuangfa.entity;

import java.io.Serializable;
import java.util.Date;

import com.chuangfa.BaseEntity;

/**
 * 用户
 * 
 * @author xgj
 * 
 */
public class UserEntity extends BaseEntity implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = -4605620709126248742L;
    /**
     * 基本信息
     */
    private Integer id;
    /**
     * 用户名
     */
    private String username;
    /**
     * 登陆密码
     */
    private String password;

    private Date lastLoginTime;

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}