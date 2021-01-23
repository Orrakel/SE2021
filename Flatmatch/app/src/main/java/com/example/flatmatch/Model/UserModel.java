package com.example.flatmatch.Model;

import android.os.StrictMode;

import com.example.flatmatch.Data.Data;
import com.example.flatmatch.Data.User;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class UserModel {

    /**
     * Die eingegebenen Daten werden mit einer Datenbankabfrage überprüft
     *
     * Die eingegebenen Daten werden an die Datenbank übergeben und wenn die Abfrage keine Daten erzeugt
     * sind die eingegebenen Informationen falsch.
     *
     * @param loginName Eingegebene Loginname
     * @param password das eingegebene Passwort
     * @return true, wenn die Userdaten stimme, false, wenn nicht
     */
    public static boolean isLoginCorrect(String loginName, String password)
    {
        String input = "";

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        URL selectUser = null;
        BufferedReader br = null;

        try {
            selectUser = new URL("http://192.168.43.35/flatmatch/selectUser.php?email=" + loginName + "&password=" + password);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        try {
            br = new BufferedReader(new InputStreamReader(selectUser.openStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            input = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Login: " + input);

        if(input.equals("{}"))
            return false;

        try {
            buildUser(input);
        } catch (JSONException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    /**
     * Der String, aus der Datenbank, wird zu einem Player umgewandelt.
     * Dafür werden auch die Deckinformationen ausgewertet.
     *
     * @param input Der Datenbank-String
     */
    private static void buildUser(String input) throws JSONException {
        User user = null;
        JSONObject userInput = new JSONObject(input);

        user = new User(userInput.getString("email"),
                userInput.getString("firstname"),
                userInput.getString("lastname"),
                userInput.getInt("age"),
                userInput.getString("picture"),
                userInput.getDouble("income"),
                userInput.getString("firstname"),
                userInput.getString("schufa").equals("yes"),
                userInput.getString("pet").equals("yes"),
                userInput.getInt("persons"));

        Data.setUser(user);
    }

    public void insertNewUser(User newUser, String password) {
        String input = "";

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        URL selectUser = null;
        BufferedReader br = null;

        String sql = "INSERT INTO Users (email, password, Firstname, Lastname, age, picture, income, job, schufa, pet, persons) VALUES " +
                "('" + newUser.getEmail() + "', " +
                "'"+ password +"', " +
                "'" + newUser.getFirstname() + "', " +
                "'" + newUser.getLastname() + "', " +
                "'" + newUser.getAge() + "', " +
                "'" + newUser.getPicture() + "', " +
                "'" + newUser.getIncome() + "', " +
                "'" + newUser.getJob() + "', " +
                "'" + newUser.getSchufaYesNo() + "', " +
                "'" + newUser.getPetYesNo() + "', " +
                "'" + newUser.getPersons() + "')";

        try {
            selectUser = new URL("http://192.168.43.35/flatmatch/insert.php?sql=" + sql);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
