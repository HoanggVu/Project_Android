package com.example.doantest.Activity.Menu;

public class Menu {
    private int resourceImage;
    private String title;
    private String price;

    public Menu(int resourceImage, String title, String price) {
        this.resourceImage = resourceImage;
        this.title = title;
        this.price = price;
    }

    public int getResourceImage() {
        return resourceImage;
    }

    public void setResourceImage(int resourceImage) {
        this.resourceImage = resourceImage;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
