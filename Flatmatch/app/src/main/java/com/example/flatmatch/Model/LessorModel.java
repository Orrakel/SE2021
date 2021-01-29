package com.example.flatmatch.Model;

import android.os.StrictMode;

import com.example.flatmatch.Data.Apartment;
import com.example.flatmatch.Data.Data;
import com.example.flatmatch.Data.Lessor;
import com.example.flatmatch.Data.User;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
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
            selectUser = new URL("http://" + Data.getIPAdress() + "/flatmatch/selectLessor.php?email=" + email + "&password=" + password);
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

        System.out.println("isLoginCorrect Login: " + input);

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
     * Der String, aus der Datenbank, wird zu einem Lessor umgewandelt.
     *
     * @param input Der Datenbank-String
     */
    private static void buildLessor(String input) throws JSONException {
        JSONObject lessorInput = new JSONObject(input);
        ArrayList<Apartment> apartments = new ArrayList<>();
        System.out.println("buildLessor " + lessorInput.getString("email"));
        System.out.println("buildLessor " + input);

        apartments = ApartmentModel.getLessorApartments(lessorInput.getString("email"));

        Lessor lessor = new Lessor(lessorInput.getString("email"),apartments);
        System.out.println("BuildLessor " + lessor);
        Data.setLessor(lessor);
    }
    /**
     * Ein neuer Vermiteter wird in die Datenbank aufgenommen
     *
     * @param newLessor Neuer Vermieter
     * @param password Passwort des neuen Vermieter
     */
    public static void insertNewUser(Lessor newLessor, String password) {
        String input = "";

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        HttpClient httpClient = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost();
        URL selectUser = null;
        BufferedReader br = null;

        String sql = "INSERT INTO Lessor (email, password) VALUES " +
                "('" + newLessor.getEmail() + "', '"+ password + "')";
        System.out.println(sql);

        sql = sql.replace(" ", "%20");

        httpPost = new HttpPost("http://" + Data.getIPAdress() + "/flatmatch/insert.php?sql=" + sql);

        try {
            HttpResponse response = httpClient.execute(httpPost);
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Eine Liste von Benutzern wird aus einem JSON-String erzeugt
     *
     * @param input JSON-String
     * @return Benutzerliste
     * @throws JSONException
     */
    private static ArrayList<User> buildUserList(String input) throws JSONException {
        ArrayList<User> users = new ArrayList<>();
        JSONObject userInput = new JSONObject(input);

        JSONObject apartmentsInput = new JSONObject(input);
        JSONArray allUsers = apartmentsInput.getJSONArray("users");

        for( int i = 0 ; i < allUsers.length()-1 ; i++) {
            User user = new User(allUsers.getJSONObject(i).getString("email"),
                    allUsers.getJSONObject(i).getString("firstname"),
                    allUsers.getJSONObject(i).getString("lastname"),
                    allUsers.getJSONObject(i).getInt("age"),
                    allUsers.getJSONObject(i).getString("picture"),
                    allUsers.getJSONObject(i).getDouble("income"),
                    allUsers.getJSONObject(i).getString("firstname"),
                    allUsers.getJSONObject(i).getString("schufa").equals("yes"),
                    allUsers.getJSONObject(i).getString("pet").equals("yes"),
                    allUsers.getJSONObject(i).getInt("persons"));

            users.add(user);
        }

        return users;
    }

    public static ArrayList<User> getMatchesFromApartment(Apartment apartment) {
        String input = "";

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        URL selectUser = null;
        BufferedReader br = null;

        try {
            selectUser = new URL("http://" + Data.getIPAdress() +
                    "/flatmatch/selectApartmentMatches.php?city=" + apartment.getCity() + "&zip=" + apartment.getZip() +
                    "&street=" + apartment.getStreet() + "&housenumber=" + apartment.getHousenumber());

            System.out.println("http://" + Data.getIPAdress() +
                    "/flatmatch/selectApartmentMatches.php?city=" + apartment.getCity() + "&zip=" + apartment.getZip() +
                    "&street=" + apartment.getStreet() + "&housenumber=" + apartment.getHousenumber());
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

        try {
            return buildUserList(input);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * Ein neuer Vermiteter wird in die Datenbank aufgenommen
     *
     * @param newLessor Neuer Vermieter
     * @param password Passwort des neuen Vermieter
     */
    public static void insertNewLessor(Lessor newLessor, String password) {
        String input = "";

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        URL selectUser = null;
        BufferedReader br = null;

        String sql = "INSERT INTO Lessor (email, password) VALUES " +
                "('" + newLessor.getEmail() + "', '"+ password + "')";

        try {
            selectUser = new URL("http://" + Data.getIPAdress() + "/flatmatch/insert.php?sql=" + sql);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Alle Benutzer, welche ein Apartment liken, werden aus der Datenbank ausgelesen und
     * als Liste zurückgegeben
     *
     * @param apartment eine Wohnung
     * @return Eine Liste von Wohnungen
     */
    public static ArrayList<User> getLikesFromApartment(Apartment apartment) {
        String input = "";

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        URL selectUser = null;
        BufferedReader br = null;

        try {
            selectUser = new URL("http://" + Data.getIPAdress() +
                    "/flatmatch/selectApartmentLikes.php?city=" + apartment.getCity() + "&zip=" + apartment.getZip() +
                    "&street=" + apartment.getStreet() + "&housenumber=" + apartment.getHousenumber());

            System.out.println("http://" + Data.getIPAdress() +
                    "/flatmatch/selectApartmentLikes.php?city=" + apartment.getCity() + "&zip=" + apartment.getZip() +
                    "&street=" + apartment.getStreet() + "&housenumber=" + apartment.getHousenumber());
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

        try {
            return buildUserList(input);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }
}
