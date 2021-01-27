package com.example.flatmatch.Presenter

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.flatmatch.Data.Data
import com.example.flatmatch.Data.Lessor
import com.example.flatmatch.Data.User
import com.example.flatmatch.Model.LessorModel
import com.example.flatmatch.Model.UserModel
import com.example.flatmatch.R
import kotlinx.android.synthetic.main.activitiy_create_account.*

/**
 * Hier wäre das Accounterstellen-Seite implementiert
 */
class CreateAccount: AppCompatActivity(){

    lateinit var radioButton: RadioButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activitiy_create_account)

        create_account_btn.setOnClickListener {
            val radioId = findViewById<RadioGroup>(R.id.createAccount_rg).checkedRadioButtonId
            radioButton = findViewById(radioId)

            if(radioButton.id.equals(R.id.createAccount_user_rb))
            {
                var user = User(email_et.text.toString(), "", "", 0, "", 0.0, "", false, false, 1)
                if (password_et.text.toString() == passwordrp_et.text.toString()) {
                    UserModel.insertNewUser(user, password_et.text.toString())
                    Data.setUser(user)
                    val intent = Intent(this, Profil::class.java)
                    startActivity(intent)
                } else {
                    Toast.makeText(this, "passwort nicht gleich", Toast.LENGTH_SHORT).show()
                }
            }
            else if(radioButton.id.equals(R.id.createAccount_lessor_rb))
            {
                if (password_et.text.toString() == passwordrp_et.text.toString()) {
                    val lessor = Lessor(email_et.text.toString(), null)
                    LessorModel.insertNewUser(lessor, password_et.text.toString())
                    println("CreateAccount" + Data.getLoggedInLessor())
                    val intent = Intent(this, ApartmentList::class.java)
                    startActivity(intent)
                }
            }
        }

    }

    fun checkButton(v: View)
    {
        val radioId = findViewById<RadioGroup>(R.id.createAccount_rg).checkedRadioButtonId

        radioButton = findViewById(radioId)

    }
}