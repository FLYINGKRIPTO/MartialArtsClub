package com.example.dell.udemyapp78maclub.model;

public class MarshalArt {
    private int martialArtID;
    private String martialArtName;
    private double martialArtPrice;
    private String martialArtColor;

    public MarshalArt(int id,String name,int price, String color){
      setMartialArtID(id);
      setMartialArtName(name);
      setMartialArtColor(color);
      setMartialArtPrice(price);
    }

    public int getMartialArtID() {
        return martialArtID;
    }

    public String getMartialArtName() {
        return martialArtName;
    }

    public double getMartialArtPrice() {
        return martialArtPrice;
    }

    public String getMartialArtColor() {
        return martialArtColor;
    }

    public void setMartialArtID(int martialArtID) {
        this.martialArtID = martialArtID;
    }

    public void setMartialArtName(String martialArtName) {
        this.martialArtName = martialArtName;
    }

    public void setMartialArtPrice(double martialArtPrice) {
        this.martialArtPrice = martialArtPrice;
    }

    public void setMartialArtColor(String martialArtColor) {
        this.martialArtColor = martialArtColor;
    }
}
