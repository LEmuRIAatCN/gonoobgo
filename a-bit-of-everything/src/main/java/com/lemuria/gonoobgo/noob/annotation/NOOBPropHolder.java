package com.lemuria.gonoobgo.noob.annotation;

import lombok.Data;

import java.util.Properties;
@Data
public class NOOBPropHolder {
    private String noobName;
    private Properties properties;
    public NOOBPropHolder(String name, Properties properties){
        this.noobName = name;
        this.properties = properties;
    }

}
