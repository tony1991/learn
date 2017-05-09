package com.alibaba.collection;

/**
 * @Desc:
 * @Author: tony
 * @Date: Created in 17/5/9 上午11:30  
 */
public class HashKey {
    int i;

    public HashKey(int i) {
        this.i = i;
    }

    @Override
    public boolean equals(Object obj){
        return true;
    }
    @Override
    public int hashCode(){
        return 1;
    }
}
