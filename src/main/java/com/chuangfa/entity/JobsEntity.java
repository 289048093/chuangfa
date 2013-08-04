package com.chuangfa.entity;

import java.io.Serializable;
import java.util.Date;

import com.chuangfa.BaseEntity;

public class JobsEntity extends BaseEntity implements Comparable<JobsEntity>,Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 2806380744048615791L;

    private Integer id;

    private String title;

    private String content;

    private Date addTime;

    private Date modTime;

    public Date getModTime() {
        return modTime;
    }

    public void setModTime(Date modTime) {
        this.modTime = modTime;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public int compareTo(JobsEntity o) {
        return o.getModTime().compareTo(this.getModTime());
    }
    
    @Override
    public boolean equals(Object obj) {
        if(obj==null){
            return false;
        }
        if(obj instanceof JobsEntity){
            return this.id.equals(((JobsEntity)obj).getId());
        }
        return false;
    }
    
    @Override
    public int hashCode() {
        return this.id*1000+this.title.length();
    }

}
