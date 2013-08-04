/**
 * Copyright(c) 2013 ShenZhen ChuangFa Technology Co., Ltd.
 * All rights reserved.
 * Created on  Apr 1, 2013  11:57:53 AM
 */
package com.chuangfa.entity;

import com.chuangfa.BaseEntity;

/**
 * 菜单
 * 
 * @author ChuangFa
 */
public class MenuEntity extends BaseEntity {
    /**
     * 
     */
    private static final long serialVersionUID = -3382154227858982137L;
    /**
     * 菜单名
     */
    private String name;
    /**
     * 菜单默认地址
     */
    private String url;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
