package com.example.flatmatch

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import com.example.flatmatch.Model.UserModel
import com.example.flatmatch.Presenter.CreateAccount
import com.example.flatmatch.Presenter.ForgotPassword
import com.example.flatmatch.Presenter.MainPage
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        login_btn.setOnClickListener {

            var status = if(UserModel.isLoginCorrect("anolting@e-mail.de","1234")) "Login Erfolgreich" else "Login fehlgeschlagen"
            Toast.makeText(this, status, LENGTH_SHORT).show()
            if(status.equals("Login Erfolgreich"))
            {
                val intent = Intent(this, MainPage::class.java)
                startActivity(intent)
            }
        }

        forgotPassword_button.setOnClickListener {
            val intent = Intent(this, ForgotPassword::class.java)
            startActivity(intent)

        }

        account_btn.setOnClickListener {

            val intent = Intent(this, CreateAccount::class.java)
            startActivity(intent)
        }
    }
}