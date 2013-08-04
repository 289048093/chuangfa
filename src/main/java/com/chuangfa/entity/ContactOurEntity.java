package com.chuangfa.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.chuangfa.BaseEntity;

public class ContactOurEntity extends BaseEntity implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 404951851897349232L;

    private String serviceTel;

    private String cooperationTel;

    private String workTime;

    private String comName;

    private String email;

    private String addr;

    private Map<Integer, SubshopInfoEntity> subShops;


    public String getServiceTel() {
        return serviceTel;
    }

    public void setServiceTel(String serviceTel) {
        this.serviceTel = serviceTel;
    }

    public String getCooperationTel() {
        return cooperationTel;
    }

    public void setCooperationTel(String cooperationTel) {
        this.cooperationTel = cooperationTel;
    }

    public String getWorkTime() {
        return workTime;
    }

    public void setWorkTime(String workTime) {
        this.workTime = workTime;
    }

    public String getComName() {
        return comName;
    }

    public void setComName(String comName) {
        this.comName = comName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public Map<Integer, SubshopInfoEntity> getSubShops() {
        return subShops;
    }

    public void setSubShops(Map<Integer, SubshopInfoEntity> subShops) {
        this.subShops = subShops;
    }

}
