package com.jorgereina.pinterestchallenge.models;

import com.google.gson.annotations.SerializedName;

public class Images {

    @SerializedName("136x136")
    private Image136 image136;
    @SerializedName("236x")
    private Image236 image236;
    @SerializedName("474x")
    private Image474 image474;
    @SerializedName("736x")
    private Image736 image736;
    @SerializedName("orig")
    private ImageOriginal imageOriginal;

    public Image136 getImage136() {
        return image136;
    }

    public void setImage136(Image136 image136) {
        this.image136 = image136;
    }

    public Image236 getImage236() {
        return image236;
    }

    public void setImage236(Image236 image236) {
        this.image236 = image236;
    }

    public Image474 getImage474() {
        return image474;
    }

    public void setImage474(Image474 image474) {
        this.image474 = image474;
    }

    public Image736 getImage736() {
        return image736;
    }

    public void setImage736(Image736 image736) {
        this.image736 = image736;
    }

    public ImageOriginal getImageOriginal() {
        return imageOriginal;
    }

    public void setImageOriginal(ImageOriginal imageOriginal) {
        this.imageOriginal = imageOriginal;
    }
}
