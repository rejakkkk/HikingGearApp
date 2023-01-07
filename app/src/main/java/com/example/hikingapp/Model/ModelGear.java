package com.example.hikingapp.Model;

public class ModelGear {
    private String title;
    private String brand;
    private String pic;
    private String price;
    private int numberCart;

    public ModelGear(String title, String brand, String pic, String price){
        this.pic = pic;
        this.brand =brand;
        this.title = title;
        this.price = price;
    }

    public ModelGear(String title, String brand, String pic, String price, int numberCart){
        this.pic = pic;
        this.brand =brand;
        this.title = title;
        this.price = price;
        this.numberCart =numberCart;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getNumberCart() {
        return numberCart;
    }

    public void setNumberCart(int numberCart) {
        this.numberCart = numberCart;
    }
}
