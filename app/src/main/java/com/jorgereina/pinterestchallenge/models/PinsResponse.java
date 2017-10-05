package com.jorgereina.pinterestchallenge.models;

import com.google.gson.annotations.SerializedName;

public class PinsResponse {

    @SerializedName("description")
    private String description;
    @SerializedName("images")
    private Images images;
    @SerializedName("title")
    private String title;
    @SerializedName("pinner")
    private Pinner pinner;

    public Pinner getPinner() {
        return pinner;
    }

    public void setPinner(Pinner pinner) {
        this.pinner = pinner;
    }

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
