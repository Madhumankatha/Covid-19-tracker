package com.madhumankatha.covid19tracker;

import com.google.gson.annotations.SerializedName;

public class Covid {

    @SerializedName("Country")
    private String CountryName;

    @SerializedName("NewConfirmed")
    private int NewCases;

    @SerializedName("TotalConfirmed")
    private int TotalCases;

    public String getCountryName() {
        return CountryName;
    }

    public void setCountryName(String countryName) {
        CountryName = countryName;
    }

    public int getNewCases() {
        return NewCases;
    }

    public void setNewCases(int newCases) {
        NewCases = newCases;
    }

    public int getTotalCases() {
        return TotalCases;
    }

    public void setTotalCases(int totalCases) {
        TotalCases = totalCases;
    }
}
