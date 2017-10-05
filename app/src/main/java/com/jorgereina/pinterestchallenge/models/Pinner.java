package com.jorgereina.pinterestchallenge.models;

import com.google.gson.annotations.SerializedName;

public class Pinner {

    @SerializedName("username")
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
