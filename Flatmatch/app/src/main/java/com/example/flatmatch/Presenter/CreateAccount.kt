package com.example.flatmatch.Presenter

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.flatmatch.Data.Data
import com.example.flatmatch.Data.User
import com.example.flatmatch.Model.UserModel
import com.example.flatmatch.R
import kotlinx.android.synthetic.main.activitiy_create_account.*

/**
 * Hier wäre das Accounterstellen-Seite implementiert
 */
class CreateAccount: AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activitiy_create_account)

        create_account_btn.setOnClickListener {
            var user = User(email_et.text.toString(), "", "", 0, "", 0.0,"", false,false,1)
            if(password_et.text.toString().equals(passwordrp_et.text.toString())) {
                UserModel.insertNewUser(user, password_et.text.toString())
                Data.setUser(user)
                val intent = Intent(this, Profil::class.java)
                startActivity(intent)
            }
            else
            {
                Toast.makeText(this, "passwort nicht gleich", Toast.LENGTH_SHORT).show()
            }
        }

    }
}