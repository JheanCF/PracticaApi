package com.jp.practicawd.models;

import com.google.gson.annotations.SerializedName;

public class Distillery {
    @SerializedName("name")
    private String nameDistillery;
    @SerializedName("slug")
    private String slugDistillery;
    @SerializedName("country")
    private String countryDistillery;

    public String getNameDistillery() {
        return nameDistillery;
    }

    public void setNameDistillery(String nameDistillery) {
        this.nameDistillery = nameDistillery;
    }

    public String getSlugDistillery() {
        return slugDistillery;
    }

    public void setSlugDistillery(String slugDistillery) {
        this.slugDistillery = slugDistillery;
    }

    public String getCountryDistillery() {
        return countryDistillery;
    }

    public void setCountryDistillery(String countryDistillery) {
        this.countryDistillery = countryDistillery;
    }
}
