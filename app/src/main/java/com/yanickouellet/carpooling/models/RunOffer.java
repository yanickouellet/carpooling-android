package com.yanickouellet.carpooling.models;

public class RunOffer extends BaseRun {
    private int places;
    private int kmValue;

    public int getPlaces() {
        return places;
    }

    public void setPlaces(int places) {
        this.places = places;
    }

    public int getKmValue() {
        return kmValue;
    }

    public void setKmValue(int kmValue) {
        this.kmValue = kmValue;
    }
}
