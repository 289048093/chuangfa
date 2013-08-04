package com.chuangfa.entity;

import java.io.Serializable;
import java.util.Date;

import com.chuangfa.BaseEntity;

public class NewsEntity extends BaseEntity implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -2808575561158466748L;

    private Integer id;

    private String title;

    private String content;

    private Date addTime;

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
}
