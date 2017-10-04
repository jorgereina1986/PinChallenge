package com.jorgereina.pinterestchallenge.models;

import com.google.gson.annotations.SerializedName;

public class PinsResponse {

    @SerializedName("description")
    String description;
    @SerializedName("images")
    Images images;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Images getImages() {
        return images;
    }

    public void setImages(Images images) {
        this.images = images;
    }
}
