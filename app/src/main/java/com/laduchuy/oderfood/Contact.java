package com.laduchuy.oderfood;

public class Contact {
    String name;
    float price;
    int img,sl=0;

    public Contact(String name, int img, float price) {
        this.name = name;
        this.img = img;
        this.price = price;
    }

    public int getSl() {
        return sl;
    }

    public void setSl(int sl) {
        this.sl = sl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
