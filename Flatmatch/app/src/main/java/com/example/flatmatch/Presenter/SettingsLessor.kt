package com.example.flatmatch.Presenter

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import com.example.flatmatch.Data.Data
import com.example.flatmatch.MainActivity
import com.example.flatmatch.R
import kotlinx.android.synthetic.main.activity_settings_lessor.*

/**
 * Hier ist die Einstellung für den Vermieter Implemntiert, man kann sich abmeloden und passwort ändern
 */
class SettingsLessor: AppCompatActivity(){
    lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

            setContentView(R.layout.activity_settings_lessor)

            toggle = ActionBarDrawerToggle(this, settingsLessor_drawerLayout,
                    R.string.open,
                    R.string.close
            )
            settingsLessor_drawerLayout.addDrawerListener(toggle)
            toggle.syncState()

            supportActionBar?.setDisplayHomeAsUpEnabled(true)

            settingsLessor_navView.setNavigationItemSelectedListener {
                when(it.itemId)
                {
                    R.id.mHome -> startActivity(Intent(this, MainPage_Lessor::class.java))
                    R.id.mMatches -> startActivity(Intent(this, MatchList_Lessor::class.java))
                    R.id.mObjects -> startActivity(Intent(this, ApartmentList::class.java))
                    R.id.mSettings -> startActivity(Intent(this, SettingsLessor::class.java))
                }
                true
            }


        settingsLessor_logout_btn.setOnClickListener {

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