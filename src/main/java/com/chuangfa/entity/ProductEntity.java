package com.chuangfa.entity;

import java.io.Serializable;
import java.util.Date;

import com.chuangfa.BaseEntity;
import com.chuangfa.util.DateUtil;

/**
 * @author CloudKing
 * 
 */
public class ProductEntity extends BaseEntity implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 5016143182825829715L;
    private Integer id;
    private String name;

    private String headPic;
    
    private String proPic;

    private String model;

    private String brand;

    private String com;

    private double price;

    private String desc;

    private Date addTime;

    private Date produceTime;

    private Integer typeId;
    /**
     * 热门产品序号
     */
    private int topIndex;

    public String getProPic() {
        return proPic;
    }

    public void setProPic(String proPic) {
        this.proPic = proPic;
    }

    public int getTopIndex() {
        return topIndex;
    }

    public void setTopIndex(int topIndex) {
        this.topIndex = topIndex;
    }

    public void setProduceTime(Date produceTime) {
        this.produceTime = produceTime;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHeadPic() {
        return headPic;
    }

    public void setHeadPic(String headPic) {
        this.headPic = headPic;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCom() {
        return com;
    }

    public void setCom(String com) {
        this.com = com;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public Date getProduceTime() {
        return produceTime;
    }

    public void setProduceTime(String produceTimeStr) {
        this.produceTime = DateUtil.parseDate(produceTimeStr);
    }
}
