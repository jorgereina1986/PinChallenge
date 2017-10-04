package com.jorgereina.pinterestchallenge.models;

import com.google.gson.annotations.SerializedName;

class ImageOriginal {

    @SerializedName("url")
    String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
