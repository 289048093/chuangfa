package com.chuangfa.entity;

import java.io.Serializable;
import java.util.Set;

import com.chuangfa.BaseEntity;

public class TypeEntity extends BaseEntity implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = -5122208152834056767L;
    private Integer id;

    private String name;

    private Set<Integer> products;

    private Set<ProductEntity> proEntitys;

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

    public Set<Integer> getProducts() {
        return products;
    }

    public void setProducts(Set<Integer> products) {
        this.products = products;
    }

    public Set<ProductEntity> getProEntitys() {
        return proEntitys;
    }

    public void setProEntitys(Set<ProductEntity> proEntitys) {
        this.proEntitys = proEntitys;
    }

}
