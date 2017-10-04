package com.jorgereina.pinterestchallenge.models;

import com.google.gson.annotations.SerializedName;

public class PinsResponse {

    @SerializedName("description")
    String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
