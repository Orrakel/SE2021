package com.example.flatmatch.Data;

import java.util.ArrayList;

public class Data {
    private static User loggedInUser = null;
    private static Lessor loggedInLessor = null;
    private static ArrayList<Apartment> likes = null;
    private static ArrayList<Apartment> matches = null;
    private static String ipAdress = "192.168.43.35";
    private static Filter filter = null;
    private static Apartment apartment = null;

    public static void setUser(User user) { loggedInUser = user; }
    public static User getLoggedInUser() { return loggedInUser; }

    public static void setLessor(Lessor lessor) { loggedInLessor = lessor; }
    public static Lessor getLoggedInLessor() { return loggedInLessor; }

    public static void setLikes(ArrayList<Apartment> likesTemp) { likes = likesTemp; }
    public static ArrayList<Apartment> getLikes(){ return likes; }

    public static void setMatches(ArrayList<Apartment> matchesTemp) { matches = matchesTemp; }
    public static ArrayList<Apartment> getMatches() { return matches; }

    public static String getIPAdress() { return ipAdress; }

    public static void setFilter(Filter filter_){ filter = filter_;}
    public static Filter getFilter(){return filter;}

    public static void setApartment(Apartment apartment_){ apartment = apartment_;}
    public static  Apartment getApartment(){ return apartment;}
}
