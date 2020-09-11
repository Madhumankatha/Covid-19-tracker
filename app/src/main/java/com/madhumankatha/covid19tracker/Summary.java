package com.madhumankatha.covid19tracker;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Summary {

    @SerializedName("Countries")
   private ArrayList<Covid> covidArrayList;


    public ArrayList<Covid> getCovidArrayList() {
        return covidArrayList;
    }

    public void setCovidArrayList(ArrayList<Covid> covidArrayList) {
        this.covidArrayList = covidArrayList;
    }
}
