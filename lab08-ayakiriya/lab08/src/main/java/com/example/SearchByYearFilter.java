package com.example;

import java.util.ArrayList;
import java.util.List;

interface Filter{
    void setCarOffers(List<CarOffer> carOffers);
    void setSearchSettings(SearchSettings searchSettings);
    boolean canFilter();
    List<CarOffer> filter();
}

public class SearchByYearFilter implements Filter {
    private List<CarOffer> carOffers;
    private SearchSettings searchSettings;

    //getters and setters
    public List<CarOffer> getCarOffers() {
        return carOffers;
    }
    public SearchSettings getSearchSettings() {
        return searchSettings;
    }

    public void setCarOffers(List<CarOffer> carOffers) {
        this.carOffers = carOffers;
    }
    public void setSearchSettings(SearchSettings searchSettings) {
        this.searchSettings = searchSettings;
    }

    public boolean canFilter(){
        if(searchSettings.getYearFrom() != null || searchSettings.getYearTo() != null){
            return true;
        } else {
            return false;
        }
    }

    public boolean compare(int i){
        boolean fitsFrom = true;
        boolean fitsTo = true;

        if(searchSettings.getYearFrom() != null){
            if(!(searchSettings.getYearFrom() <= carOffers.get(i).getYear())){
                fitsFrom = false;
            }
        }

        if(searchSettings.getYearTo() != null){
            if(!(searchSettings.getYearTo() > carOffers.get(i).getYear())){
                fitsTo = false;
            }
        }

        return (fitsFrom && fitsTo);
    }

    public List<CarOffer> filter(){
        List<CarOffer> filteredList = new ArrayList<CarOffer>();

        for (int i = 0; i < carOffers.size(); i++) {
            if(compare(i)){
                filteredList.add(carOffers.get(i));
            }
        }

        return filteredList;
    }
}
