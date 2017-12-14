package com.mireagaloideal.apportame.data;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Jordán Rosas on 13/12/2017.
 */

public class RegaloFromWS {

    private String name;
    @SerializedName("prices")
    private String price;
    private String url_image;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getUrl_image() {
        return url_image;
    }

    public void setUrl_image(String url_image) {
        this.url_image = url_image;
    }
}
