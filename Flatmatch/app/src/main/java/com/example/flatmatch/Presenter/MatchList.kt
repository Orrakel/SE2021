package com.example.flatmatch.Presenter

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.flatmatch.Data.Apartment
import com.example.flatmatch.Data.Flat
import com.example.flatmatch.Model.ApartmentModel
import com.example.flatmatch.Model.FlatAdapter
import com.example.flatmatch.R
import kotlinx.android.synthetic.main.activitiy_main_page.drawerLayout
import kotlinx.android.synthetic.main.activitiy_main_page.navView
import kotlinx.android.synthetic.main.activitiy_match_list.*

class MatchList : AppCompatActivity(), FlatAdapter.OnItemClickListener{

    lateinit var toggle: ActionBarDrawerToggle
    private lateinit var matchList: MutableList<Apartment>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activitiy_match_list)

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
        var test =  ApartmentModel.getAllApartments()
        val city = test[0].city.toString()
        // DATEN HOLEN Nick pls halp
        matchList = mutableListOf(
            Apartment(
                "city",
                "",
                "",
                "",
                10.0f,
                true,
                3,
                5.5f,
                true,
                false,
                "",
                ""
            ),
            Apartment(
                "Minden",
                "",
                "",
                "",
                10.0f,
                true,
                3,
                5.5f,
                true,
                false,
                "",
                ""
            ),
            Apartment(
                "Bad Oeynhausen",
                "",
                "",
                "",
                10.0f,
                true,
                3,
                5.5f,
                true,
                false,
                "",
                ""
            ),
            Apartment(
                "Lübbecke",
                "",
                "",
                "",
                10.0f,
                true,
                3,
                5.5f,
                true,
                false,
                "",
                ""
            )
        )

        val adapter = FlatAdapter(matchList, this)
        rvMatches.adapter = adapter
        rvMatches.layoutManager = LinearLayoutManager(this)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if(toggle.onOptionsItemSelected(item))
        {
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onItemClick(position: Int) {
        Toast.makeText(this, "Item $position clicked", Toast.LENGTH_SHORT).show()
        val clickedItem = matchList[position]
        startActivity(Intent(this, MatchShow::class.java))
    }
}