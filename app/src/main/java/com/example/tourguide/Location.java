package com.example.tourguide;

public class Location {

    private int locationId;
    private String address;
    private String name;
    private String description;
    private double rating;
    private String  phoneNumber;

    private final static int NO_IMAGE_PROVIDED = -1;
    private int imageResourceId = NO_IMAGE_PROVIDED;

    public Location(int locationId,  String name, String address,String description, double rating, String phoneNumber) {
        this.locationId = locationId;
        this.address = address;
        this.name = name;
        this.description = description;
        this.rating = rating;
        this.phoneNumber = phoneNumber;
    }

    public Location(int locationId, String name, String address,  String description, double rating, String phoneNumber, int imageResourceId) {
        this.locationId = locationId;
        this.address = address;
        this.name = name;
        this.description = description;
        this.rating = rating;
        this.phoneNumber = phoneNumber;
        this.imageResourceId = imageResourceId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getLocationId() {
        return locationId;
    }

    public String getAddress() {
        return address;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public float getRating() {
        return (float) rating;
    }

    public boolean hasImage(){
        return imageResourceId != NO_IMAGE_PROVIDED;
    }
}
