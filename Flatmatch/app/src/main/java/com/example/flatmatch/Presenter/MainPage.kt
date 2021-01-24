package com.example.flatmatch.Presenter

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.widget.*
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import butterknife.ButterKnife
import com.example.flatmatch.Data.Apartment
import com.example.flatmatch.Model.ApartmentModel
import com.example.flatmatch.R
import com.lorentzos.flingswipe.SwipeFlingAdapterView
import com.lorentzos.flingswipe.SwipeFlingAdapterView.onFlingListener
import kotlinx.android.synthetic.main.activitiy_main_page.*


/**
 * Hier ist die swipefunktion implementiert. Es sollten durch den filter Objekte gefiltert werden die dann angezeigt werden
 * man kann nach links und rechts swipen. Es wird aber nicht gespeichert.
 */
class MainPage : AppCompatActivity(){


    lateinit var toggle: ActionBarDrawerToggle

    lateinit var apartments: ArrayList<Apartment>
    lateinit var arrayAdapter: ArrayAdapter<Apartment>



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activitiy_main_page)
        ButterKnife.inject(this)
        var dataFilter: com.example.flatmatch.Data.Filter = com.example.flatmatch.Data.Filter()

        val datafilter = com.example.flatmatch.Data.Filter()
        if ( intent != null) {
            datafilter.setFilter(
                intent.getStringExtra("city"),
                intent.getFloatExtra("costMin", 0.0f),
                intent.getFloatExtra("costMax", 20000.0F),
                intent.getFloatExtra("sizeMin", 0.0F),
                intent.getFloatExtra("sizeMax", 300.0F),
                intent.getIntExtra("roomsMin", 0),
                intent.getIntExtra("roomsMax", 10),
                intent.getBooleanExtra("arePetsAllowed", false),
                intent.getBooleanExtra("commercialUsage", false),
                intent.getBooleanExtra("furnishingPresent", false)
            )
        }
        toggle = ActionBarDrawerToggle(this, drawerLayout,
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
        apartments = java.util.ArrayList<Apartment>()


        apartments = ApartmentModel.getAllApartments()
        arrayAdapter = ArrayAdapter(this, R.layout.item, R.id.helloText, apartments)

        val flingContainer: SwipeFlingAdapterView = findViewById(R.id.frame)
        flingContainer.setAdapter(arrayAdapter)
        flingContainer.setFlingListener(object : onFlingListener {
            override fun removeFirstObjectInAdapter() {
                // this is the simplest way to delete an object from the Adapter (/AdapterView)
                Log.d("LIST", "removed object!")
                apartments.removeAt(0)
                arrayAdapter.notifyDataSetChanged()
            }

            override fun onLeftCardExit(dataObject: Any) {

                Toast.makeText(this@MainPage, "Like! $dataObject", Toast.LENGTH_SHORT).show()
            }

            override fun onRightCardExit(dataObject: Any) {
                Toast.makeText(this@MainPage, "Dislike!", Toast.LENGTH_SHORT).show()
            }

            override fun onAdapterAboutToEmpty(itemsInAdapter: Int) {
                // Ask for more data her
                arrayAdapter.notifyDataSetChanged()
                Log.d("LIST", "notified")

            }

            override fun onScroll(scrollProgressPercent: Float) {

            }
        })

        // Optionally add an OnItemClickListener
        flingContainer.setOnItemClickListener(
                object : SwipeFlingAdapterView.OnItemClickListener {
                    lateinit var dialogBuilder: AlertDialog.Builder
                    lateinit var  dialog: AlertDialog
                    lateinit var city: TextView
                    lateinit var cost: TextView
                    lateinit var rooms: TextView
                    lateinit var zip: TextView
                    lateinit var street: TextView
                    lateinit var houseNumber: TextView
                    lateinit var size: TextView
                    lateinit var arePetsAllowed: TextView
                    lateinit var commercialUsageAllowed: TextView
                    lateinit var furnishingPresent: TextView
                    lateinit var description: TextView
                    lateinit var btn_cancel: Button
                    override fun onItemClicked(itemPosition: Int, dataObject: Any) {



                        dialogBuilder = AlertDialog.Builder(this@MainPage)
                        var popUpView: View = layoutInflater.inflate(R.layout.popup_menu, null)
                        city = popUpView.findViewById(R.id.popUp_city)
                        cost = popUpView.findViewById(R.id.popUp_cost)
                        rooms = popUpView.findViewById(R.id.popUp_rooms)
                        zip = popUpView.findViewById(R.id.popUp_zip)
                        street = popUpView.findViewById(R.id.popUp_street)
                        houseNumber = popUpView.findViewById(R.id.popUp_houseNumber)
                        size = popUpView.findViewById(R.id.popUp_size)
                        arePetsAllowed = popUpView.findViewById(R.id.popUp_arePetsAllowed)
                        commercialUsageAllowed = popUpView.findViewById(R.id.popUp_commercialUsageAllowed)
                        furnishingPresent = popUpView.findViewById(R.id.popUp_furnishingPresent)
                        description = popUpView.findViewById(R.id.popUp_description)
                        btn_cancel = popUpView.findViewById(R.id.popUp_btn_cancel)


                        city.text = "Stadt: " + apartments.get(itemPosition).city
                        cost.text = "Kosten: " + apartments.get(itemPosition).costs.toString()
                        zip.text = "PLZ: " + apartments.get(itemPosition).zip.toString()
                        street.text = "Straße: " + apartments.get(itemPosition).street.toString()
                        houseNumber.text = "Hausnummer: " + apartments.get(itemPosition).housenumber
                        size.text = "Größe: " + apartments.get(itemPosition).size.toString()
                        arePetsAllowed.text = "Haustiere: " + apartments.get(itemPosition).petallowedYesNo.toString()
                        commercialUsageAllowed.text = "Commercial Usage: " + apartments.get(itemPosition).commercialusageYesNo.toString()
                        furnishingPresent.text = "Furnishing Present: " + apartments.get(itemPosition).furnishingYesNo.toString()
                        description.text = "Beschreibung: " + apartments.get(itemPosition).description.toString()

                        dialogBuilder.setView(popUpView)
                        dialog = dialogBuilder.create()
                        dialog.show()

                        btn_cancel.setOnClickListener{
                            dialog.dismiss()
                        }
                    }
                })
    }
    // Optionally add an OnItemClickListener


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
    fun createPopup(){

    }
}