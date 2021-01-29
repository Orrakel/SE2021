package com.example.flatmatch.Presenter

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import com.example.flatmatch.Data.Data
import com.example.flatmatch.MainActivity
import com.example.flatmatch.R
import kotlinx.android.synthetic.main.activitiy_main_page.*
import kotlinx.android.synthetic.main.activitiy_main_page.drawerLayout
import kotlinx.android.synthetic.main.activitiy_main_page.navView
import kotlinx.android.synthetic.main.activitiy_settings.*
import kotlinx.android.synthetic.main.activity_apartment_show.*

/**
 * Hier ist die Einstellung Implemntiert, man kann sich abmelden und passwort ändern
 */
class Settings: AppCompatActivity(){
    lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

            setContentView(R.layout.activitiy_settings)

            toggle = ActionBarDrawerToggle(this, settings_drawerLayout,
                    R.string.open,
                    R.string.close
            )
            settings_drawerLayout.addDrawerListener(toggle)
            toggle.syncState()

            supportActionBar?.setDisplayHomeAsUpEnabled(true)

            settings_navView.setNavigationItemSelectedListener {
                when (it.itemId) {
                    R.id.mProfil -> startActivity(Intent(this, Profil::class.java))
                    R.id.mMatches -> startActivity(Intent(this, MatchList::class.java))
                    R.id.mFilter -> startActivity(Intent(this, Filter::class.java))
                    R.id.mSettings -> startActivity(Intent(this, Settings::class.java))
                }
                true
            }



        settings_logout_btn.setOnClickListener {

            Data.setApartment(null)
            Data.setFilter(null)
            Data.setLessor(null)
            Data.setLikes(null)
            Data.setMatches(null)
            Data.setUser(null)
            startActivity(Intent(this, MainActivity::class.java))
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