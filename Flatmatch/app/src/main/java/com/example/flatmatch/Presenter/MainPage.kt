package com.example.flatmatch.Presenter

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import butterknife.ButterKnife
import com.example.flatmatch.Data.Apartment
import com.example.flatmatch.Model.ApartmentModel
import com.example.flatmatch.R
import com.lorentzos.flingswipe.SwipeFlingAdapterView
import com.lorentzos.flingswipe.SwipeFlingAdapterView.onFlingListener
import kotlinx.android.synthetic.main.activitiy_main_page.*


class MainPage : AppCompatActivity(){


    lateinit var toggle: ActionBarDrawerToggle

    lateinit var apartments: ArrayList<Apartment>
    lateinit var arrayAdapter: ArrayAdapter<Apartment>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activitiy_main_page)
        ButterKnife.inject(this)


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
                R.id.mFilter -> startActivity(Intent(this, Settings::class.java))
            }
            true
        }
        apartments = java.util.ArrayList<Apartment>()
//        apartments.add(Apartment("Espelkamp", "1234", "Straße", "24", 10.5f, true, 3, 760.0f, false, true, "", ""))
//        apartments.add(Apartment("Minden", "1234", "Straße", "24", 10.5f, true, 3, 760.0f, false, true, "", ""))
//        apartments.add(Apartment("Lübbecke", "1234", "Straße", "24", 10.5f, true, 3, 760.0f, false, true, "", ""))
//        apartments.add(Apartment("Rahden", "1234", "Straße", "24", 10.5f, true, 3, 760.0f, false, true, "", ""))
//        apartments.add(Apartment("Hille", "1234", "Straße", "24", 10.5f, true, 3, 760.0f, false, true, "", ""))
//        apartments.add(Apartment("Bad Oeynhausen", "1234", "Straße", "24", 10.5f, true, 3, 760.0f, false, true, "", ""))
//        apartments.add(Apartment("Bad Salzufen", "1234", "Straße", "24", 10.5f, true, 3, 760.0f, false, true, "", ""))
//        apartments.add(Apartment("Klein Bremen", "1234", "Straße", "24", 10.5f, true, 3, 760.0f, false, true, "", ""))

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
                //Do something on the left!
                //You also have access to the original object.
                //If you want to use it just cast it (String) dataObject
                Toast.makeText(this@MainPage, "Left!", Toast.LENGTH_SHORT).show()
            }

            override fun onRightCardExit(dataObject: Any) {
                Toast.makeText(this@MainPage, "Right!", Toast.LENGTH_SHORT).show()
            }

            override fun onAdapterAboutToEmpty(itemsInAdapter: Int) {
                // Ask for more data her
                arrayAdapter.notifyDataSetChanged()
                Log.d("LIST", "notified")

            }

            override fun onScroll(scrollProgressPercent: Float) {
//                View view = flingContainer.getSelectedView();
//                view.findViewById(R.id.item_swipe_right_indicator).setAlpha(scrollProgressPercent < 0 ? -scrollProgressPercent : 0);
//                view.findViewById(R.id.item_swipe_left_indicator).setAlpha(scrollProgressPercent > 0 ? scrollProgressPercent : 0);
            }
        })

        // Optionally add an OnItemClickListener
        flingContainer.setOnItemClickListener(
                object : SwipeFlingAdapterView.OnItemClickListener {
                    override fun onItemClicked(itemPosition: Int, dataObject: Any) {
                        Toast.makeText(this@MainPage, "Clicked!", Toast.LENGTH_SHORT).show()
                        Intent(this@MainPage, MatchShow::class.java).also{
                            it.putExtra("position",itemPosition)
                            startActivity(it)
                        }
                    }
                })
    }
    // Optionally add an OnItemClickListener



    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if(toggle.onOptionsItemSelected(item))
        {
            return true
        }
        return super.onOptionsItemSelected(item)
    }

}