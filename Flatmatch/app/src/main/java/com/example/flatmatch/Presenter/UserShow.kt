package com.example.flatmatch.Presenter

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import com.example.flatmatch.Model.ApartmentModel
import com.example.flatmatch.R
import kotlinx.android.synthetic.main.activitiy_main_page.*
import kotlinx.android.synthetic.main.activitiy_main_page.navView
import kotlinx.android.synthetic.main.activity_user_show.*

class UserShow : AppCompatActivity(){

    lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_show)

        toggle = ActionBarDrawerToggle(this, user_drawerLayout,
            R.string.open,
            R.string.close
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        navView.setNavigationItemSelectedListener {
            when(it.itemId)
            {
                R.id.mProfil -> startActivity(Intent(this, Profil::class.java))
                R.id.mMatches -> startActivity(Intent(this, MatchList::class.java))
                R.id.mFilter -> startActivity(Intent(this, Filter::class.java))
                R.id.mSettings -> startActivity(Intent(this, Settings::class.java))
            }
            true
        }

        val users = ApartmentModel.getLessorMatches().get(intent.getIntExtra("position", -1))

        emailUserShow_tv.text = "Stadt: " + users.city
        ageUserShow_tv.text = "PLZ: " + users.zip
        firstnameUserShow_tv.text = "Straße: " + users.street
        lastnameUserShow_tv.text =  users.housenumber
        incomeUserShow_tv.text = "Größe: " + users.size.toString()
        jobShow_tv.text = "Haustier: " + users.petallowedYesNo
        ShufaUserShow_tv.text = "Räume: " + users.room.toString()
        petUserShow_tv.text = "Kosten: " + users.costs.toString()
        personsUserShow_tv.text = "Commercial Usage: " + users.commercialusageYesNo




        userShow_chat_btn.setOnClickListener {

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