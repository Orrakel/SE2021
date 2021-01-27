package com.example.flatmatch.Model;

import android.os.StrictMode;

import com.example.flatmatch.Data.Apartment;
import com.example.flatmatch.Data.Data;
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

public class ApartmentModel {

    public static ArrayList<Apartment> getAllApartments()
    {
        String input = "";

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        URL selectUser = null;
        BufferedReader br = null;
        ArrayList<Apartment> apartments = null;

        try {
            selectUser = new URL("http://" + Data.getIPAdress() + "/flatmatch/selectAllApartment.php");
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
            return null;

        try {
            apartments = buildApartmentList(input);
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }

        return apartments;
    }

    public static ArrayList<Apartment> getApartments()
    {
        String input = "";

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        URL selectUser = null;
        BufferedReader br = null;
        ArrayList<Apartment> apartments = null;

        try {
            selectUser = new URL("http://" + Data.getIPAdress() + "/flatmatch/selectApartment.php");
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
            return null;

        try {
            apartments = buildApartmentList(input);
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }

        return apartments;
    }

    public static ArrayList<Apartment> getLessorApartments() {
        String input = "";

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        URL selectUser = null;
        BufferedReader br = null;
        ArrayList<Apartment> apartments = null;

        try {
            selectUser = new URL("http://" + Data.getIPAdress() + "/flatmatch/selectLessorApartment.php?email=" + Data.getLoggedInLessor().getEmail());
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
            return null;

        try {
            apartments = buildApartmentList(input);
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }

        return apartments;
    }

    public static ArrayList<Apartment> getLikes() {
        String input = "";

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        URL selectUser = null;
        BufferedReader br = null;
        ArrayList<Apartment> apartments = null;

        try {
            selectUser = new URL("http://" + Data.getIPAdress() + "/flatmatch/selectLikes.php?email=" + Data.getLoggedInUser().getEmail());
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
            return null;

        try {
            apartments = buildApartmentList(input);
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }

        return apartments;
    }

    public static ArrayList<Apartment> getMatches() {
        String input = "";

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        URL selectUser = null;
        BufferedReader br = null;
        ArrayList<Apartment> apartments = null;

        try {
            selectUser = new URL("http://" + Data.getIPAdress() + "/flatmatch/selectLikes.php?email=" + Data.getLoggedInUser().getEmail());
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
            return null;

        try {
            apartments = buildApartmentList(input);
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }

        return apartments;
    }

    private static ArrayList<Apartment> buildApartmentList(String input) throws JSONException {
        ArrayList<Apartment> apartments = new ArrayList<>();
        JSONObject apartmentsInput = new JSONObject(input);
        JSONArray allApartments = apartmentsInput.getJSONArray("apartments");

        for( int i = 0 ; i < allApartments.length()-1 ; i++) {
            Apartment apartment = new Apartment(allApartments.getJSONObject(i).getString("city"),
                    allApartments.getJSONObject(i).getString("zip"),
                    allApartments.getJSONObject(i).getString("street"),
                    allApartments.getJSONObject(i).getString("housenumber"),
                    allApartments.getJSONObject(i).getInt("size"),
                    allApartments.getJSONObject(i).getString("petallowed").equals("yes"),
                    allApartments.getJSONObject(i).getInt("room"),
                    allApartments.getJSONObject(i).getInt("costs"),
                    allApartments.getJSONObject(i).getString("commercialusage").equals("yes"),
                    allApartments.getJSONObject(i).getString("furnishing").equals("yes"),
                    allApartments.getJSONObject(i).getString("description"),
                    allApartments.getJSONObject(i).getString("email"));
            apartments.add(apartment);
        }

        return apartments;
    }

    public static void insertApartment(Apartment newApartment) {
        String input = "";

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        HttpClient httpClient = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost();

        String sql = "INSERT INTO apartment (city, zip, street, housenumber, email, size, petallowed, room, costs, commercialusage, furnishing, description)  VALUES " +
                "('" + newApartment.getCity() + "', " +
                "'" + newApartment.getZip() + "', " +
                "'" + newApartment.getStreet() + "', " +
                "'" + newApartment.getHousenumber() + "', " +
                "'" + Data.getLoggedInLessor().getEmail() + "', " +
                "'" + newApartment.getSize() + "', " +
                "'" + newApartment.getPetallowedYesNo() + "', " +
                "'" + newApartment.getRoom() + "', " +
                "'" + newApartment.getCommercialusageYesNo() + "', " +
                "'" + newApartment.getFurnishingYesNo() + "', " +
                "'" + newApartment.getDescription() + "')";

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

    public static void insertLike(Apartment newLikedApartment) {
        String input = "";

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        HttpClient httpClient = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost();

        String sql = "INSERT INTO likes (city, zip, street, housenumber, email, email_0)  VALUES " +
                "('" + newLikedApartment.getCity() + "', " +
                "'" + newLikedApartment.getZip() + "', " +
                "'" + newLikedApartment.getStreet() + "', " +
                "'" + newLikedApartment.getHousenumber() + "', " +
                "'" + Data.getLoggedInLessor().getEmail() + "', " +
                "'" + newLikedApartment.getLessorMail() + ")";

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

    public static void insertMatch(Apartment newApartmentMatch) {
        String input = "";

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        HttpClient httpClient = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost();

        String sql = "INSERT INTO apartment (city, zip, street, housenumber, Usersemail, lessoremail) VALUES " +
                "('" + newApartmentMatch.getCity() + "'," +
                "'" + newApartmentMatch.getZip() + "', " +
                "'" + newApartmentMatch.getStreet() + "', " +
                "'" + newApartmentMatch.getHousenumber() + "', " +
                "'" + Data.getLoggedInLessor().getEmail() + "', " +
                "'" + newApartmentMatch.getLessorMail() + "')";

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


}
