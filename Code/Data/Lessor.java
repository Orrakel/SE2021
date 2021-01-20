package com.example.flatmatch.Data;

import java.util.ArrayList;

public class Lessor {
    private String email;
    ArrayList<Apartment> apartments;

    public Lessor(String email, ArrayList<Apartment> apartments) {
        this.email = email;
        this.apartments = apartments;
    }

    public String getEmail() { return this.email; }
}
