package com.app.android.deal.dealclub;

import com.google.gson.annotations.SerializedName;

public class Movie {

    @SerializedName("productname")
    private String productname;


    @SerializedName("percentage")
    private String percentage;


    @SerializedName("validfrom")
    private String validfrom;


    @SerializedName("validtill")
    private String validtill;

    @SerializedName("id")
    private String id;

    public Movie(String productname, String percentage, String validfrom, String validtill, String id) {
        this.productname = productname;
        this.percentage = percentage;
        this.validfrom = validfrom;
        this.validtill = validtill;
        this.id = id;
    }

    public String getProductname() {
        return productname;
    }

    public String getPercentage() {
        return percentage;
    }

    public String getValidfrom() {
        return validfrom;
    }

    public String getValidtill() {
        return validtill;
    }

    public String getId() {
        return id;
    }
}