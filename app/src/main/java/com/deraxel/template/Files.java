package com.deraxel.template;

import java.io.Serializable;

/**
 * Created by Derxe on 4/6/2017.
 */

public class Files implements Serializable {
    private String name;
    private String data;
    public void setName(String x){
        name=x;
    }
    public String getName(){
        return name;
    }
    public void setData(String x){
        data=x;
    }
    public String getData(){
        return data;
    }
}
