package com.example.flatmatch.Data;

public class Data {
    private static User loggedInUser = null;
    private static Lessor loggedInLessor = null;

    public static void setUser(User user) { loggedInUser = user; }
    public static User getLoggedInUser() { return loggedInUser; }

    public static void setLessor(Lessor lessor) { loggedInLessor = lessor; }
    public static Lessor getLoggedInLessor() { return loggedInLessor; }
}
