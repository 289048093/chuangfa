package com.chuangfa.entity;

import java.io.Serializable;

import com.chuangfa.BaseEntity;

public class SubshopInfoEntity extends BaseEntity implements Serializable{
    /**
     * 
     */
    private static final long serialVersionUID = -8621400870643064470L;

    private Integer id;

    private String name;

    private String telphone;

    private String contacter;

    private String addr;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelphone() {
        return telphone;
    }

    public void setTelphone(String telphone) {
        this.telphone = telphone;
    }

    public String getContacter() {
        return contacter;
    }

    public void setContacter(String contacter) {
        this.contacter = contacter;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }
}
