package com.example.flatmatch.Data;

public class User {

    private String email;
    private String firstname;
    private String lastname;
    private int age;
    private double income;
    private String picture;
    private String job;
    private boolean schufa;
    private boolean pet;
    private int persons;

    public User(String email, String firstname, String lastname, int age, String picture,
                double income, String job, boolean schufa, boolean pet, int persons) {
        this.email = email;
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
        this.income = income;
        this. picture = picture;
        this.job = job;
        this.schufa = schufa;
        this.pet = pet;
        this.persons = persons;
    }

    public String getEmail(){ return this.email; }

    public String getFirstname() { return this.firstname; }

    public String getLastname() { return this.lastname; }

    public int getAge() { return this.age; }

    public String getPicture() { return this.picture; }

    public double getIncome() { return this.income; }

    public String getJob() { return this.job; }

    public String getSchufaYesNo() { return this.schufa?"yes":"no"; }

    public String getPetYesNo() { return this.pet?"yes":"no"; }

    public int getPersons() { return this.persons; }
}
