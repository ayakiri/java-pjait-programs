package com.example;

import java.util.ArrayList;
import java.util.List;

public class Searcher {
    public List<Filter> filters = new ArrayList<Filter>();

    public void addFilter(Filter filter){
        filters.add(filter);
    }

    public List<CarOffer> filter(List<CarOffer> cars, SearchSettings searchSettings){
        List<CarOffer> filteredList = new ArrayList<CarOffer>();

        for (int i = 0; i < cars.size(); i++) {
            for (int j = 0; j < filters.size(); j++) {
                if(filters.get(j).canFilter()){
                    filteredList = filters.get(j).filter();
                }
            }
        }

        return filteredList;
    }
}
