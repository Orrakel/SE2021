package com.example.flatmatch.Presenter

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import com.example.flatmatch.Data.User
import com.example.flatmatch.Model.ApartmentModel
import com.example.flatmatch.R
import kotlinx.android.synthetic.main.activity_match_show_lessor.*

/**
 * zeigt Das Objekt an was angeklickt wurde.
 *
 */
class MatchShow_Lessor : AppCompatActivity(){

    lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_match_show_lessor)

        toggle = ActionBarDrawerToggle(this, MatchShowLessor_drawerLayout,
                R.string.open,
                R.string.close
        )
        MatchShowLessor_drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        navView.setNavigationItemSelectedListener {
            when(it.itemId)
            {
                R.id.mProfil -> startActivity(Intent(this, Profil::class.java))
                R.id.mMatches -> startActivity(Intent(this, MatchList_Lessor::class.java))
                R.id.mFilter -> startActivity(Intent(this, Filter::class.java))
                R.id.mSettings -> startActivity(Intent(this, Settings::class.java))
            }
            true
        }

        //val user = ApartmentModel.getLessorMatches().get(intent.getIntExtra("position", -1))
        val user = User("anolting@e-mail.de", "Alex", "Sucher", 27, "test", 1000.0, "bubun", true, true, 1)
        firstnameMatchShowLessor_tv.text = "Name: " + user.firstname
        lastnameMatchShowLessor_tv.text = user.lastname
        incomeMatchShowLessor_tv.text = "Einkommen: " + user.income.toString()
        jobMatchShowLessor_tv.text =  "Job" + user.job
        ageMatchShowLessor_tv.text = "Alter: " + user.age.toString()
        arePetAllowedMatchShowLessor_tv.text = "Haustier: " + user.petYesNo
        schufaMatchShowLessor_tv.text = "Schufa: " + user.schufaYesNo.toString()
        personsMatchShowLessor_tv.text = "Personen: " + user.persons.toString()




        matchShow_chat_btn.setOnClickListener {

            startActivity(Intent(this, Chat::class.java))
        }

        matchShow_delete_btn.setOnClickListener {
            startActivity((Intent(this, MatchList::class.java)))
        }
    }
    /**
     * ermittelt ob ein Menüpunkt angeklickt wurde
     * @return super.onOptionsItemSelected(), true falls ja, sonst false
     */
    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if(toggle.onOptionsItemSelected(item))
        {
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}