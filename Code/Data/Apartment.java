package com.example.flatmatch.Data;

public class Apartment {

    private String city;
    private String zip;
    private String street;
    private String houseNumber;
    private float size;
    private boolean arePetsAllowed;
    private int rooms;
    private float costs;
    private boolean commercialUsageAllowed;
    private boolean furnishingPresent;
    private String description;
    private String lessorEmail;

    public Apartment(String city, String zip, String street, String houseNumber, float size,
                     boolean arePetsAllowed, int rooms, float costs, boolean commercialUsageAllowed,
                     boolean furnishingPresent, String description, String lessorEmail) {
        this.city = city;
        this.zip = zip;
        this.street = street;
        this.houseNumber = houseNumber;
        this.size = size;
        this.arePetsAllowed = arePetsAllowed;
        this.rooms = rooms;
        this.costs = costs;
        this.commercialUsageAllowed = commercialUsageAllowed;
        this.furnishingPresent = furnishingPresent;
        this.description = description;
        this.lessorEmail = lessorEmail;
    }

    public String getCity() { return this.city; }

    public String getZip() { return this.zip; }

    public String getStreet() { return this.street; }

    public String getHousenumber() { return this.houseNumber; }

    public float getSize() { return this.size; }

    public String getPetallowedYesNo() { return this.arePetsAllowed?"yes":"no"; }

    public int getRoom() { return this.rooms; }

    public String getCommercialusageYesNo() { return this.commercialUsageAllowed?"yes":"no"; }

    public String getFurnishingYesNo() { return this.furnishingPresent?"yes":"no"; }

    public String getDescription() { return this.description; }

    public String getLessorMail() { return this.lessorEmail; }
}
