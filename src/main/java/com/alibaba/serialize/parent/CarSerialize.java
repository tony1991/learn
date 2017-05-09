package com.alibaba.serialize.parent;

import java.io.Serializable;

/**
 * 类CarSerialize.java的实现描述：TODO 类实现描述 
 * @author tony 2015年7月28日 上午9:54:16
 */
public class CarSerialize{
    private String name;
    private Long price;
    
    /*
     * 没有这个无参构造函数会报错
     */
    public CarSerialize() {
        super();
    }

    public CarSerialize(String name, Long price) {
        this.name = name;
        this.price = price;
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
