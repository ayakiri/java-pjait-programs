package com.example;

import java.util.ArrayList;
import java.util.List;

public class DictionaryCache {
    private List<DictionaryValue> items;

    private DictionaryCache(){}

    private static DictionaryCache instance;


    public static synchronized DictionaryCache getInstance(){
        if(instance==null) instance = new DictionaryCache();
        return instance;
    }

    public void setItems(List<DictionaryValue> values){
        this.items = values;
    }

    public List<DictionaryValue> getItems() {
        return items;
    }
}
