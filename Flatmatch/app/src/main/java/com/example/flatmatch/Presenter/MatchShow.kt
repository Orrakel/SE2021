package com.example.flatmatch.Presenter

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import com.example.flatmatch.Model.ApartmentModel
import com.example.flatmatch.R
import kotlinx.android.synthetic.main.activitiy_main_page.*
import kotlinx.android.synthetic.main.activitiy_main_page.drawerLayout
import kotlinx.android.synthetic.main.activitiy_main_page.navView
import kotlinx.android.synthetic.main.activitiy_match_show.*

class MatchShow : AppCompatActivity(){

    lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activitiy_match_show)

        toggle = ActionBarDrawerToggle(this, drawerLayout,
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
                R.id.mFilter -> startActivity(Intent(this, Settings::class.java))
            }
            true
        }

        val flat = ApartmentModel.getAllApartments().get(intent.getIntExtra("position", -1))

        cityMatchShow_tv.text = flat.city
        zipMatchShow_tv.text = flat.zip
        streetMatchShow_tv.text = flat.street
        houseNumberMatchShow_tv.text = flat.housenumber
        emailMatchShow_tv.text = flat.housenumber
        sizeMatchShow_tv.text = flat.size.toString()
        arePetAllowedatchShow_tv.text = flat.petallowedYesNo
        roomsMatchShow_tv.text = flat.room.toString()
        costsMatchShow_tv.text = flat.costs.toString()
        commercialUsageAllowedMatchShow_tv.text = flat.commercialusageYesNo
        furnishingPresentMatchShow_tv.text = flat.furnishingYesNo
        decriptionMatchShow_tv.text = flat.description




    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if(toggle.onOptionsItemSelected(item))
        {
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}