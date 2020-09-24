package com.allong.example.domain;

import java.io.Serializable;
import java.util.Arrays;

public class UserInfo implements Serializable {
    private int id;

    private byte[] images;

    private String description;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public byte[] getImages() {
        return images;
    }

    public void setImages(byte[] images) {
        this.images = images;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "id=" + id +
                ", images=" + Arrays.toString(images) +
                ", description='" + description + '\'' +
                '}';
    }
}
