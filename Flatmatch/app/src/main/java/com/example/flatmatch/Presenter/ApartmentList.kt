package com.example.flatmatch.Presenter

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.flatmatch.Data.Apartment
import com.example.flatmatch.Model.ApartmentModel
import com.example.flatmatch.Adapter.FlatAdapter
import com.example.flatmatch.Data.Data
import com.example.flatmatch.R
import kotlinx.android.synthetic.main.activitiy_main_page.drawerLayout
import kotlinx.android.synthetic.main.activitiy_main_page.navView
import kotlinx.android.synthetic.main.activity_apartment_list.*

class ApartmentList : AppCompatActivity(), FlatAdapter.OnItemClickListener{

    lateinit var toggle: ActionBarDrawerToggle
    private lateinit var objectList: MutableList<Apartment>

    /**
     * Erstellung der Ansicht Alle Aprtments von einem Lessor
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_apartment_list)

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
                R.id.mHome -> startActivity(Intent(this, MainPage_Lessor::class.java))
                R.id.mMatches -> startActivity(Intent(this, MatchList_Lessor::class.java))
                R.id.mObjects -> startActivity(Intent(this, ApartmentList::class.java))
                R.id.mSettings -> startActivity(Intent(this, SettingsLessor::class.java))

            }
            true
        }
        objectList = java.util.ArrayList<Apartment>()
        println("ApartmentList: " + Data.getLoggedInLessor().email)
        objectList = ApartmentModel.getLessorApartments(Data.getLoggedInLessor().email).toMutableList()
//        objectList.add(Apartment("BadSalzuflen", "32107", "DetmolderWeg", "3",
//                    120.0f, true, 2, 750.0f, false, true,
//                    "HierwohnteeineBerühmtheitdasistwahrglaubensiemir.", "nkoetter@e-mail.de"))

        val adapter = FlatAdapter(objectList, this)
        rvLikes.adapter = adapter
        rvLikes.layoutManager = LinearLayoutManager(this)

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

    /**
     * bei klick eines Feldes wird auf die Ansicht des Apartments gewechselt
     * @param position, die position des geklicktem Feldes
     */
    override fun onItemClick(position: Int) {
        Toast.makeText(this, "Item $position clicked", Toast.LENGTH_SHORT).show()
        val clickedItem = objectList[position]
        Intent(this, ApartmentShow::class.java).also{
            it.putExtra("position",position)
            startActivity(it)
        }
    }
}