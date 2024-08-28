package com.akademicu.mytattooapp.model;

import java.util.List;

public class PexelResponse {
    private int total_results;
    private List<Photo>photos;

    public int getTotal_results() {
        return total_results;
    }

    public List<Photo> getPhotos() {
        return photos;
    }
}
