package com.example.flatmatch.Presenter

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import com.example.flatmatch.Data.Data
import com.example.flatmatch.R
import kotlinx.android.synthetic.main.activitiy_main_page.drawerLayout
import kotlinx.android.synthetic.main.activitiy_main_page.navView
import kotlinx.android.synthetic.main.activity_filter.*
import java.lang.NumberFormatException

/**
 * Hier wäre die Filterseite implementiert
 */
class Filter  : AppCompatActivity() {

    lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_filter)

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

        println(Data.getFilter())
        if (Data.getFilter() != null){
            filter_city_et.setText(Data.getFilter().city)
            if(Data.getFilter().sizeMin > -1) filter_sizemin_et.setText(Data.getFilter().sizeMin.toString())
            if(Data.getFilter().sizeMax > -1)filter_sizemax_et.setText(Data.getFilter().sizeMax.toString())
            if(Data.getFilter().roomMin > -1)filter_roomsmin_et.setText(Data.getFilter().roomMin.toString())
            if(Data.getFilter().sizeMin > -1)filter_roomsmax_et.setText((Data.getFilter().roomMax.toString()))
            filter_petyes.isChecked = Data.getFilter().petallowedYesNo
            if(Data.getFilter().costsMin > -1)filter_costsmin_et.setText(Data.getFilter().costsMin.toString())
            if(Data.getFilter().costsMax > -1)filter_costsmax_et.setText(Data.getFilter().costsMax.toString())
            filter_commercialUsageYes.isChecked = Data.getFilter().commercialusageYesNo
            filter_furnishingYes.isChecked = Data.getFilter().furnishingYesNo


        }

        filter_safeFilter_btn.setOnClickListener{

            val filterCity: String = try {
                filter_city_et.text.toString()
            } catch(e: NumberFormatException) {
                ""
            }
            val filterSizeMin: Float = try {
                filter_sizemin_et.text.toString().toFloat()
            } catch (e: NumberFormatException) {
                -1-0f
            }


            val filterSizeMax: Float = try {
                filter_sizemax_et.text.toString().toFloat()
            } catch (e: NumberFormatException) {
                -1.0f
            }
            val filterRoomsMin: Int = try{
                filter_roomsmin_et.text.toString().toInt()
            } catch (e: NumberFormatException) {
                -1
            }
            val filterRoomsMax: Int = try{
                filter_roomsmax_et.text.toString().toInt()
            } catch (e: NumberFormatException) {
                -1
            }
            val filterPets: Boolean = filter_petyes.isChecked
            val filterCostsMin: Float = try{
                filter_costsmin_et.text.toString().toFloat()
            } catch (e: NumberFormatException) {
                -1.0f
            }
            val filterCostsMax: Float = try{
                filter_costsmax_et.text.toString().toFloat()
            } catch (e: NumberFormatException) {
                -1.0f
            }
            val filterCommercial: Boolean = filter_commercialUsageYes.isChecked
            val filterFurnishing: Boolean = filter_furnishingYes.isChecked

            Data.setFilter(com.example.flatmatch.Data.Filter(filterCity,filterSizeMin , filterSizeMax,filterRoomsMin ,
                    filterRoomsMax ,filterPets , filterCostsMin,filterCostsMax ,filterCommercial ,filterFurnishing))

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
    private fun saveData()
    {
        val sharedPreferences: SharedPreferences = getSharedPreferences("sharedPref", Context.MODE_PRIVATE)
        val editor: SharedPreferences.Editor = sharedPreferences.edit()

        editor.apply {
            putString("filterCity", Data.getFilter().city.toString())
            putFloat("filterSizeMin", Data.getFilter().sizeMin)
            putFloat("filterSizeMax", Data.getFilter().sizeMax)
            putInt("filterRoomsMin", Data.getFilter().roomMin)
            putInt("filterRoomsMax", Data.getFilter().roomMax)
            putBoolean("filterPets", Data.getFilter().petallowedYesNo)
            putFloat("filterCostsMin", Data.getFilter().costsMin)
            putFloat("filterCostsMax", Data.getFilter().costsMax)
            putBoolean("filterCommercial", Data.getFilter().commercialusageYesNo)
            putBoolean("filterFurnishing", Data.getFilter().furnishingYesNo)

        }.apply()
    }

}