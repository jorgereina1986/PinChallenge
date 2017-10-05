package com.jorgereina.pinterestchallenge.models;

import com.google.gson.annotations.SerializedName;

public class PinsResponse {

    @SerializedName("description")
    String description;
    @SerializedName("images")
    Images images;
    @SerializedName("title")
    String title;

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
