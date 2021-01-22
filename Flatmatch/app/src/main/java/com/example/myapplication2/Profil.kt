package com.example.myapplication2

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activitiy_main_page.*
import kotlinx.android.synthetic.main.activitiy_profil.*
import kotlinx.android.synthetic.main.activitiy_main_page.drawerLayout as drawerLayout1
import kotlinx.android.synthetic.main.activitiy_profil.navView as navView1

class Profil: AppCompatActivity(){

    lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activitiy_profil)

        toggle = ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close)
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

        safe_profil_btn.setOnClickListener {
            val intent = Intent(this, MainPage::class.java)
            startActivity(intent)
        }

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if(toggle.onOptionsItemSelected(item))
        {
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}
