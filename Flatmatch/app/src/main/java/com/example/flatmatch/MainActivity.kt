package com.example.flatmatch

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import com.example.flatmatch.Data.Apartment
import com.example.flatmatch.Data.Data
import com.example.flatmatch.Model.ApartmentModel
import com.example.flatmatch.Model.LessorModel
import com.example.flatmatch.Model.UserModel
import com.example.flatmatch.Presenter.CreateAccount
import com.example.flatmatch.Presenter.ForgotPassword
import com.example.flatmatch.Presenter.MainPage
import kotlinx.android.synthetic.main.activity_main.*

/**
 * das ist das Logging, es wird nach der Email und dem passwort gefragt
 * Man kann auch zu der Account erstellen Seite gehen und Passwort vergessen
 */
class MainActivity : AppCompatActivity() {
    lateinit var radioButton: RadioButton
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        login_btn.setOnClickListener {
            val radioId = findViewById<RadioGroup>(R.id.login_rg).checkedRadioButtonId
            val radioButton = findViewById<View>(radioId)

            if(radioButton.id == R.id.login_user_rb) {


                //var status = if(UserModel.isLoginCorrect(username_et.text.toString(),password_et.text.toString())) "Login Erfolgreich" else "Login fehlgeschlagen"
                //println(UserModel.isLoginCorrect("anolting@e-mail.de","1234"))
                //var status = if(UserModel.isLoginCorrect("anolting@e-mail.de","1234")) "Login Erfolgreich" else "Login fehlgeschlagen"
                var status = if (UserModel.isLoginCorrect("kneitmann@e-mail.de", "4321")
                ) "Login Erfolgreich" else "Login fehlgeschlagen"
                Toast.makeText(this, status, LENGTH_SHORT).show()
                if (status.equals("Login Erfolgreich")) {

                    val intent = Intent(this, MainPage::class.java)
                    startActivity(intent)
                }
            }
            else if(radioButton.id == R.id.login_lessor_rb)
            {
                var status = if (LessorModel.isLoginCorrect("nkoetter@e-mail.de", "1234")
                ) "Login Erfolgreich" else "Login fehlgeschlagen"
                Toast.makeText(this, status, LENGTH_SHORT).show()
                if (status.equals("Login Erfolgreich")) {

                    val intent = Intent(this, MainPage::class.java)
                    startActivity(intent)
                }
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

    fun checkButton(v:View)
    {
        val radioId = findViewById<RadioGroup>(R.id.login_rg).checkedRadioButtonId

        radioButton = findViewById(radioId)
    }
}