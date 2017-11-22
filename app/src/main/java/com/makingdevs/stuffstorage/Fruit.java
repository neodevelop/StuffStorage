package com.makingdevs.stuffstorage;

/**
 * Created by makingdevs on 21/11/17.
 */

public class Fruit {

    private String kind;
    private String size;
    private String property;
    private String benefit;

    public Fruit() {
    }

    public Fruit(String kind, String size, String property, String benfit) {
        this.kind = kind;
        this.size = size;
        this.property = property;
        this.benefit = benfit;
    }

    @Override
    public String toString() {
        return "Fruit{" +
                "kind='" + kind + '\'' +
                ", size='" + size + '\'' +
                ", property='" + property + '\'' +
                ", benefit='" + benefit + '\'' +
                '}';
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public String getBenefit() {
        return benefit;
    }

    public void setBenefit(String benefit) {
        this.benefit = benefit;
    }
}
