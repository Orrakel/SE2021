package com.example.flatmatch.Presenter

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import com.example.flatmatch.Data.Apartment
import com.example.flatmatch.Data.Data
import com.example.flatmatch.Data.User
import com.example.flatmatch.Model.ApartmentModel
import com.example.flatmatch.Model.UserModel
import com.example.flatmatch.R
import kotlinx.android.synthetic.main.activitiy_main_page.*
import kotlinx.android.synthetic.main.activitiy_match_show.*
import kotlinx.android.synthetic.main.activitiy_profil.*
import kotlinx.android.synthetic.main.activity_apartment_show.*

class ApartmentShow: AppCompatActivity(){

    lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_apartment_show)

        toggle = ActionBarDrawerToggle(this, apartmentShow_drawerLayout,
                R.string.open,
                R.string.close
        )
        apartmentShow_drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        apartmentShow_navView.setNavigationItemSelectedListener {
            when(it.itemId)
            {
                R.id.mHome -> startActivity(Intent(this, MainPage_Lessor::class.java))
                R.id.mMatches -> startActivity(Intent(this, MatchList::class.java))
                R.id.mObjects -> startActivity(Intent(this, ApartmentList::class.java))
                R.id.mSettings -> startActivity(Intent(this, Settings_lessor::class.java))
            }
            true
        }

        //php und funktionen funktionieren nicht oder sind noch nicht da
        //val user = Data.getLoggedInLessor().apartments[intent.getIntExtra("position", -1)]
        val apartment = Apartment("BadSalzuflen", "32107", "DetmolderWeg", "3",
                120.0f, true, 2, 750.0f, false, true,
                "HierwohnteeineBerühmtheitdasistwahrglaubensiemir.", "nkoetter@e-mail.de")

        cityApartmentShow_et.setText(apartment.city.toString())
        streetApartmentShow_et.setText(apartment.street.toString())
        houseNumberApartmentShow_et.setText(apartment.housenumber.toString())
        zipApartmentShow_et.setText(apartment.zip.toString())
        costsApartmentShow_et.setText((apartment.costs.toString()))
        sizeApartmentShow_et.setText(apartment.size.toString())
        descriptionApartmentShow_et.setText((apartment.description.toString()))
        commercialApartmentShow_cb.isChecked = apartment.commercial
        petApartmentShow_cb.isChecked = apartment.pets
        furnishingApartmentShow_cb.isChecked = apartment.furnishing

        safe_apartmentShow_btn.setOnClickListener {




            val apartment2 = Apartment(cityApartmentShow_et.text.toString(), zipApartmentShow_et.text.toString(), streetApartmentShow_et.text.toString(), houseNumberApartmentShow_et.text.toString(),
                    sizeApartmentShow_et.text.toString().toFloat(), petApartmentShow_cb.isChecked, roomsMatchShow_tv.text.toString().toInt(), costsApartmentShow_et.text.toString().toFloat(),
                    commercialApartmentShow_cb.isChecked, furnishingApartmentShow_cb.isChecked,
            descriptionApartmentShow_et.text.toString(), apartment.lessorMail)

            //php und funktionen funktionieren nicht oder sind noch nicht da
//            Data.getLoggedInLessor().apartments.remove(apartment)
//            Data.getLoggedInLessor().apartments.add(apartment2)
//            ApartmentModel.updateApartment(apartment2)

            startActivity(Intent(this, ApartmentList::class.java ))
        }

        delete_apartmentShow_btn.setOnClickListener {

            //php und funktionen funktionieren nicht oder sind noch nicht da
//            ApartmentModel.deleteApartment(apartment)
//            Data.getLoggedInLessor().apartments.remove(apartment)

            startActivity(Intent(this, ApartmentList::class.java ))
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