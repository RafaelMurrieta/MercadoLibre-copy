package com.murrydev.mercadolibre;

import android.widget.ImageView;

public class ofertElement {
    public String title;

    public ofertElement(String title, String imgn) {
        this.title = title;
        this.imgn = imgn;
    }

    public String imgn;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImgn() {
        return imgn;
    }

    public void setImgn(String imgn) {
        this.imgn = imgn;
    }
}
