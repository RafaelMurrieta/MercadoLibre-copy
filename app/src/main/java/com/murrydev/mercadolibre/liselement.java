package com.murrydev.mercadolibre;

public class liselement {

    String textoTop;
    String title;
    String price;
    String img;

    public liselement(String textoTop, String title, String price, String img) {
        this.textoTop = textoTop;
        this.title = title;
        this.price = price;
        this.img = img;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getTextoTop() {
        return textoTop;
    }

    public void setTextoTop(String textoTop) {
        this.textoTop = textoTop;
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
