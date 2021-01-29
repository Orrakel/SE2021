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
    /**
     * Eine Liste von allen Wohnungen wird aus der Datenbank abgerufen, erzeugt und zurückgegeben
     *
     * @return Liste von allen Wohnungen
     */
    public static ArrayList<Apartment> getAllApartments() {
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

        if (input.equals("{}"))
            return null;

        try {
            apartments = buildApartmentList(input);
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }

        return apartments;
    }
    /**
     * Eine Liste von allen Wohnungen, die von dem eingeloggten Benutzer noch nicht geliked oder
     * gematched wurde, wird aus der Datenbank abgerufen, erzeugt und zurückgegeben
     *
     * @return List von Wohnungen, die weder in den Likes noch den Matches sind
     */
    public static ArrayList<Apartment> getApartments() {
        String input = "";

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        URL selectUser = null;
        BufferedReader br = null;
        ArrayList<Apartment> apartments = null;

        try {
            selectUser = new URL("http://" + Data.getIPAdress()
                    + "/flatmatch/selectApartment.php?email=" + Data.getLoggedInUser().getEmail());
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

        if (input.equals("{}"))
            return null;

        try {
            apartments = buildApartmentList(input);
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }

        return apartments;
    }
    /**
     * Eine Liste von allen Wohnungen, die zu dem eingeloggten Vermieter gehören,
     * wird aus der Datenbank abgerufen, erzeugt und zurückgegeben
     *
     * @return Liste von Wohnung von einem Vermieter
     */
    public static ArrayList<Apartment> getLessorApartments(String email) {
        String input = "";

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        URL selectUser = null;
        BufferedReader br = null;
        ArrayList<Apartment> apartments = null;
        System.out.println(Data.getLoggedInLessor());
        try {
            selectUser = new URL("http://" + Data.getIPAdress() + "/flatmatch/selectLessorApartment.php?email=" + email);
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

        System.out.println("getLessorApartment Login: " + input);

        if (input.equals("{}"))
            return null;

        try {
            apartments = buildApartmentList(input);
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }

        return apartments;
    }
    /**
     * Eine Lste von Wohnung, welche von dem eingeloggten Benutzer geliked wurden,
     * wird abgerufen, erzeugt und zurückgegeben
     *
     * @return Liste von gelikten Wohnungen
     */
    public static ArrayList<Apartment> getLikes() {
        String input = "";

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        URL selectUser = null;
        BufferedReader br = null;
        ArrayList<Apartment> apartments = null;

        try {
            selectUser = new URL("http://" + Data.getIPAdress() + "/flatmatch/selectLikes.php?email=" + Data.getLoggedInLessor().getEmail());
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

        if (input.equals("{}"))
            return null;

        try {
            apartments = buildApartmentList(input);
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }

        return apartments;
    }
    /**
     * Eine Lste von Wohnung, welche von dem eingeloggten Benutzer gematched wurden,
     * wird abgerufen, erzeugt und zurückgegeben
     *
     * @return Liste von gemachted Wohnungen
     */
    public static ArrayList<Apartment> getMatches() {
        String input = "";

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        URL selectUser = null;
        BufferedReader br = null;
        ArrayList<Apartment> apartments = null;

        try {
            selectUser = new URL("http://" + Data.getIPAdress() + "/flatmatch/selectMatches.php?email=" + Data.getLoggedInUser().getEmail());
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

        if (input.equals("{}"))
            return null;

        try {
            apartments = buildApartmentList(input);
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }

        return apartments;
    }


    /**
     * Erzeugt aus einem JSON-Objekt eine Liste von Apartment-Objekten
     *
     * @param input eine JSON-Liste von Apartments
     * @return Eine Liste von Apartment-Objekten
     * @throws JSONException
     */
    private static ArrayList<Apartment> buildApartmentList(String input) throws JSONException {
        ArrayList<Apartment> apartments = new ArrayList<>();
        JSONObject apartmentsInput = new JSONObject(input);
        JSONArray allApartments = apartmentsInput.getJSONArray("apartments");

        for (int i = 0; i < allApartments.length() - 1; i++) {
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
    /**
     * Eine neue Wohnung wird in die Datenbank eingefügt
     *
     * @param newApartment Neu einzufügende Wohnung
     */
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
    /**
     * Eine neu gelikte Wohnung wird in die Datenbank eingefügt.
     *
     * @param newLikedApartment eine neu gelikte Wohnung
     */
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
                "'" + Data.getLoggedInUser().getEmail() + "', " +
                "'" + newLikedApartment.getLessorMail() + "')";
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
     * Ein neues Match wird in die Datenbank aufgenommen
     *
     * @param newApartmentMatch ein gematches Apartment
     */
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
                "'" + Data.getLoggedInUser().getEmail() + "', " +
                "'" + newApartmentMatch.getLessorMail() + "')";

        System.out.println("insertMatch: " + sql);
        sql = sql.replace(" ", "%20");
        System.out.println("insertMatch: " + sql);
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
     * Wohnungen werden gefiltert aus der Datenbank abgefragt, erzeugt und bereitgestellt
     *
     * @param city Stadt
     * @param minSize minimale größe
     * @param maxSize maximale größe
     * @param minRooms Mindestanzahl an Räumen
     * @param maxRooms Maximalanzahl an Räumen
     * @param petsAllowed sind Tiere in der Wohnung erlaubt
     * @param minCosts Mindestkosten
     * @param maxCosts Maximalkosten
     * @param commercialUsage ist gewerbliche Nutzung erlaubt
     * @param furnishing ist die Wohnung eingerichtet
     * @return Liste mit passenden Wohnungen
     */
    public static ArrayList<Apartment> getFilteredApartments(String city, double minSize,
                                                             double maxSize, int minRooms,
                                                             int maxRooms, boolean petsAllowed,
                                                             double minCosts, double maxCosts,
                                                             boolean commercialUsage, boolean furnishing) {
        String input = "";

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        URL selectUser = null;
        BufferedReader br = null;
        ArrayList<Apartment> apartments = null;

        String petsAllowedYesNo = "NA";
        String commercialUsageYesNo = "NA";
        String furnishingYesNo = "NA";

        if (city == null || city.equals(""))
            city = "Minden";

        if (petsAllowed)
            petsAllowedYesNo = "Yes";

        if (commercialUsage)
            commercialUsageYesNo = "Yes";

        if (furnishing)
            furnishingYesNo = "Yes";


        try {
            selectUser = new URL("http://" + Data.getIPAdress() + "/flatmatch/selectFilteredApartment.php?" +
                    "city=" + city + "&minSize=" + minSize + "&maxSize=" + maxSize +
                    "&minRooms=" + minRooms + "&maxRooms=" + maxRooms + "&petsAllowed=" + petsAllowedYesNo +
                    "&minCosts=" + minCosts + "&maxCosts=" + maxCosts + "&commercialUsage=" + commercialUsageYesNo +
                    "&furnishing=" + furnishingYesNo);

            System.out.println("http://" + Data.getIPAdress() + "/flatmatch/selectFilteredApartment.php?" +
                    "city=" + city + "&minSize=" + minSize + "&maxSize=" + maxSize +
                    "&minRooms=" + minRooms + "&maxRooms=" + maxRooms + "&petsAllowed=" + petsAllowedYesNo +
                    "&minCosts=" + minCosts + "&maxCosts=" + maxCosts + "&commercialUsage=" + commercialUsageYesNo +
                    "&furnishing=" + furnishingYesNo);
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

        if (input.equals("{}"))
            return null;

        try {
            apartments = buildApartmentList(input);
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }

        return apartments;
    }

    public static ArrayList<Apartment> getLessorMatches() {
        String input = "";

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        URL selectUser = null;
        BufferedReader br = null;
        ArrayList<Apartment> apartments = null;

        try {
            selectUser = new URL("http://" + Data.getIPAdress() + "/flatmatch/selectLikes.php?email=" + Data.getLoggedInLessor().getEmail());
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
}
