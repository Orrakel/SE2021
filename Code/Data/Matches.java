package com.example.flatmatch.Data;

public class Matches {
    private Apartment apartment;
    private User user;
    private Lessor lessor;

    public Matches(Apartment apartment, User user, Lessor lessor) {
        this.apartment = apartment;
        this.user = user;
        this.lessor = lessor;
    }
}
