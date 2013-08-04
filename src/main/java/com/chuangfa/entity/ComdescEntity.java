package com.chuangfa.entity;

import java.io.Serializable;

import com.chuangfa.BaseEntity;

public class ComdescEntity extends BaseEntity implements Serializable{
    /**
     * 
     */
    private static final long serialVersionUID = -7048253275827141210L;

    private String name;
    
    private String content;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
