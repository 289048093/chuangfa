/**
 * Copyright(c) 2013 ShenZhen ChuangFa Technology Co., Ltd.
 * All rights reserved.
 * Created on  Apr 27, 2013  5:53:10 PM
 */
package com.chuangfa.entity;

import com.chuangfa.BaseEntity;

/**
 * 属性
 * 
 * @author ChuangFa
 * 
 */
public class PropertyEntity extends BaseEntity {
    /**
     * 
     */
    private static final long serialVersionUID = -570091927344410119L;
    /**
     * 基本信息
     */
    /**
     * 键
     */
    private String key;
    /**
     * 值
     */
    private String value;

    /**
     * 默认值
     */
    private String defaultValue;

    /**
     * 描述
     */
    private String desc;

    public String getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

}
