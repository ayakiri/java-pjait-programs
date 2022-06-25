package com.example;

import java.util.List;

public class DictionaryValue {
    private Integer id;
    private Integer intKey;
    private String stringKey;
    private String name;
    private String value;

    public DictionaryValue(Integer id, Integer intKey, String stringKey, String name, String value){
        this.id = id;
        this.intKey = intKey;
        this.stringKey = stringKey;
        this.name = name;
        this.value = value;
    }

    public Integer getId() {
        return id;
    }

    public Integer getIntKey() {
        return intKey;
    }

    public String getStringKey() {
        return stringKey;
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setIntKey(Integer intKey) {
        this.intKey = intKey;
    }

    public void setStringKey(String stringKey) {
        this.stringKey = stringKey;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
