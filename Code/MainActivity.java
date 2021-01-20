package com.example.flatmatch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.flatmatch.Data.Data;
import com.example.flatmatch.Model.UserModel;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(UserModel.isLoginCorrect("kneitmann@e-mail.de", "4321")) {
            System.out.println(Data.getLoggedInUser().getEmail());
        }
        else {
            System.out.println("!!!!!!!!!!!!!!!!FEHLER!!!!!!!!!!!!!!!!");
        }
    }
}