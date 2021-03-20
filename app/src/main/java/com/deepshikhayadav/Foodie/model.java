package com.deepshikhayadav.Foodie;

public class model {
    private String offer;
    private String text;
    private int imgid;

    public model(String text, int imgid, String offer) {
        this.text = text;
        this.imgid = imgid;
        this.offer=offer;
    }

    public String getOffer() {
        return offer;
    }

    public void setOffer(String offer) {
        this.offer = offer;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getImgid() {
        return imgid;
    }

    public void setImgid(int imgid) {
        this.imgid = imgid;
    }
}
