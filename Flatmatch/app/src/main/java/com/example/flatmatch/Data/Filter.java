package com.example.flatmatch.Data;

public class Filter {

    private String city;
    private float costMin;
    private float costMax;
    private float sizeMin;
    private float sizeMax;
    private int roomsMin;
    private int roomsMax;
    private boolean arePetsAllowed;
    private boolean commercialUsage;
    private boolean furnishingPresent;

    public Filter()
    {
    }

    public void setFilter(String city_, float costMin_, float costMax_, float sizeMin_, float sizeMax_, int roomsMin_, int roomsMax_, boolean arePetsAllowed_, boolean commercialUsage_, boolean furnishingPresent_)
    {
        city = city_;
        costMin = costMin_;
        costMax = costMax_;
        sizeMin = sizeMin_;
        sizeMax = sizeMax_;
        roomsMin = roomsMin_;
         roomsMax = roomsMax_;
         arePetsAllowed = arePetsAllowed_;
         commercialUsage = commercialUsage_;
        furnishingPresent = furnishingPresent_;
    }

    public String getCity() { return this.city; }


    public float getSizeMin() { return this.sizeMin; }
    public float getSizeMax() { return this.sizeMax; }

    public String getPetallowedYesNo() { return this.arePetsAllowed?"yes":"no"; }

    public int getRoomMin() { return this.roomsMin; }
    public int getRoomMax() { return this.roomsMax; }

    public String getCommercialusageYesNo() { return this.commercialUsage?"yes":"no"; }

    public String getFurnishingYesNo() { return this.furnishingPresent?"yes":"no"; }

    public float getCostsMax() { return this.costMax; }
    public float getCostsMin() { return this.costMin; }
}
