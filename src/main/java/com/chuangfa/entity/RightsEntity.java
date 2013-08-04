/**
 * Copyright(c) 2013 ShenZhen ChuangFa Technology Co., Ltd.
 * All rights reserved.
 * Created on  Apr 1, 2013  11:56:24 AM
 */
package com.chuangfa.entity;

import com.chuangfa.BaseEntity;

/**
 * @author ChuangFa
 */
public class RightsEntity extends BaseEntity {

    /**
     * 
     */
    private static final long serialVersionUID = 6385953472519742260L;
    /**
     * 权限名称
     */
    private String name;
    /**
     * 请求地址
     */
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
