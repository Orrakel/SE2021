package com.example.flatmatch.Model;

import android.os.StrictMode;

import com.example.flatmatch.Data.Apartment;
import com.example.flatmatch.Data.Data;
import com.example.flatmatch.Data.Lessor;
import com.example.flatmatch.Data.User;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class LessorModel {

    /**
     * Die eingegebenen Daten werden mit einer Datenbankabfrage überprüft
     *
     * Die eingegebenen Daten werden an die Datenbank übergeben und wenn die Abfrage keine Daten erzeugt
     * sind die eingegebenen Informationen falsch.
     *
     * @param email Eingegebene Loginname
     * @param password das eingegebene Passwort
     * @return true, wenn die Userdaten stimme, false, wenn nicht
     */
    public static boolean isLoginCorrect(String email, String password)
    {
        String input = "";

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        URL selectUser = null;
        BufferedReader br = null;

        try {
            selectUser = new URL("http://192.168.43.35/flatmatch/selectLessor.php?email=" + email + "&password=" + password);
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
            buildLessor(input);
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
    private static void buildLessor(String input) throws JSONException {
        JSONObject lessorInput = new JSONObject(input);
        ArrayList<Apartment> apartments = new ArrayList<>();

        apartments = ApartmentModel.getLessorApartments();

        Lessor lessor = new Lessor(lessorInput.getString("email"),apartments);

        Data.setLessor(lessor);
    }

    public void insertNewUser(Lessor newLessor, String password) {
        String input = "";

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        URL selectUser = null;
        BufferedReader br = null;

        String sql = "INSERT INTO Lessor (email, password) VALUES " +
                "('" + newLessor.getEmail() + "', '"+ password + "')";

        try {
            selectUser = new URL("http://192.168.43.35/flatmatch/insert.php?sql=" + sql);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
