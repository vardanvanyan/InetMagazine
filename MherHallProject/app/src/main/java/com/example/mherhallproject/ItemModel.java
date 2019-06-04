package com.example.mherhallproject;

public class ItemModel {
   private String image;
   private String  name;
   private double price;
    private Boolean liked;
    private Boolean toBasket;


    public ItemModel(String image, String name, double price, Boolean liked, Boolean toBasket) {
        this.image = image;
        this.name = name;
        this.price = price;
        this.liked = liked;
        this.toBasket = toBasket;

    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Boolean getLiked() {
        return liked;
    }

    public void setLiked(Boolean liked) {
        this.liked = liked;
    }

    public Boolean getToBasket() {
        return toBasket;
    }

    public void setToBasket(Boolean toBasket) {
        this.toBasket = toBasket;
    }
}
