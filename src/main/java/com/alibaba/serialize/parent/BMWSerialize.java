package com.alibaba.serialize.parent;

import java.io.Serializable;

public class BMWSerialize extends CarSerialize implements Serializable{
    private String name;
    private Long price;
    
    public BMWSerialize(String name, Long price) {
        super(name, price);
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public Long getPrice() {
        return price;
    }
    
    public void setPrice(Long price) {
        this.price = price;
    }
    
}
