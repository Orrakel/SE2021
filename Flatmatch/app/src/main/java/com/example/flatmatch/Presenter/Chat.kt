package com.example.flatmatch.Presenter

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import com.example.flatmatch.R
import kotlinx.android.synthetic.main.activitiy_main_page.drawerLayout
import kotlinx.android.synthetic.main.activitiy_main_page.navView

/**
 * Hier wäre die Chatfunktion implemtiert
 *
 *
 */
class Chat: AppCompatActivity() {

    lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)

        toggle = ActionBarDrawerToggle(
            this, drawerLayout,
            R.string.open,
            R.string.close
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        navView.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.mProfil -> startActivity(Intent(this, Profil::class.java))
                R.id.mMatches -> startActivity(Intent(this, MatchList::class.java))
                R.id.mFilter -> startActivity(Intent(this, Filter::class.java))
                R.id.mSettings -> startActivity(Intent(this, Settings::class.java))
            }
            true
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