package com.example;

import java.util.ArrayList;
import java.util.List;

public class SearchByMillageFilter implements Filter {
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
        if(searchSettings.getMilleageFrom() != null || searchSettings.getMilleageTo() != null){
            return true;
        } else {
            return false;
        }
    }

    public boolean compare(int i){
        boolean fitsFrom = true;
        boolean fitsTo = true;

        if(searchSettings.getMilleageFrom() != null){
            if(!(searchSettings.getMilleageFrom() <= carOffers.get(i).getMilleage())){
                fitsFrom = false;
            }
        }

        if(searchSettings.getMilleageTo() != null){
            if(!(searchSettings.getMilleageTo() > carOffers.get(i).getMilleage())){
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
