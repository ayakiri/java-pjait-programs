package com.example;

import java.time.LocalDate;

public class SearchSettings {
    private LocalDate DateFrom;
    private LocalDate DateTo;
    private String Word;
    private Double PriceFrom;
    private Double PriceTo;
    private Integer MilleageFrom;
    private Integer MilleageTo;
    private Integer YearFrom;
    private Integer YearTo;

    //getters
    public LocalDate getDateFrom() {
        return DateFrom;
    }
    public LocalDate getDateTo() {
        return DateTo;
    }
    public String getWord() {
        return Word;
    }
    public Double getPriceFrom() {
        return PriceFrom;
    }
    public Double getPriceTo() {
        return PriceTo;
    }
    public Integer getMilleageFrom() {
        return MilleageFrom;
    }
    public Integer getMilleageTo() {
        return MilleageTo;
    }
    public Integer getYearFrom() {
        return YearFrom;
    }
    public Integer getYearTo() {
        return YearTo;
    }

    //setters
    public void setDateFrom(LocalDate dateFrom) {
        DateFrom = dateFrom;
    }
    public void setDateTo(LocalDate dateTo) {
        DateTo = dateTo;
    }
    public void setWord(String word) {
        Word = word;
    }
    public void setPriceFrom(Double priceFrom) {
        PriceFrom = priceFrom;
    }
    public void setPriceTo(Double priceTo) {
        PriceTo = priceTo;
    }
    public void setMilleageFrom(Integer milleageFrom) {
        MilleageFrom = milleageFrom;
    }
    public void setMilleageTo(Integer milleageTo) {
        MilleageTo = milleageTo;
    }
    public void setYearFrom(Integer yearFrom) {
        YearFrom = yearFrom;
    }
    public void setYearTo(Integer yearTo) {
        YearTo = yearTo;
    }
}
