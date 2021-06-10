package com.jp.practicawd.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Whisky {
    @SerializedName("name")
    private String nameWhisky;
    @SerializedName("slug")
    private String slugWhisky;
    @SerializedName("url")
    private String urlWhisky;
    @SerializedName("base_currency")
    private String moneyWhisky;




    public String getNameWhisky() {
        return nameWhisky;
    }

    public void setNameWhisky(String nameWhisky) {
        this.nameWhisky = nameWhisky;
    }

    public String getSlugWhisky() {
        return slugWhisky;
    }

    public void setSlugWhisky(String slugWhisky) {
        this.slugWhisky = slugWhisky;
    }

    public String getUrlWhisky() {
        return urlWhisky;
    }

    public void setUrlWhisky(String urlWhisky) {
        this.urlWhisky = urlWhisky;
    }

    public String getMoneyWhisky() {
        return moneyWhisky;
    }

    public void setMoneyWhisky(String moneyWhisky) {
        this.moneyWhisky = moneyWhisky;
    }
}
