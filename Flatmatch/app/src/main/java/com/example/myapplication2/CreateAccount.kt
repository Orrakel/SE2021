package com.example.myapplication2

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activitiy_create_account.*

class CreateAccount: AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activitiy_create_account)

        create_account_btn.setOnClickListener {
            val intent = Intent(this, Profil::class.java)
            startActivity(intent)
        }

    }
}