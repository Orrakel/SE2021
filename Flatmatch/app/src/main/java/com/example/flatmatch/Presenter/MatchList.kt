package com.example.flatmatch.Presenter

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.flatmatch.Data.Flat
import com.example.flatmatch.Model.FlatAdapter
import com.example.flatmatch.R
import kotlinx.android.synthetic.main.activitiy_main_page.drawerLayout
import kotlinx.android.synthetic.main.activitiy_main_page.navView
import kotlinx.android.synthetic.main.activitiy_match_list.*

class MatchList : AppCompatActivity(), FlatAdapter.OnItemClickListener{

    lateinit var toggle: ActionBarDrawerToggle
    private lateinit var matchList: MutableList<Flat>

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

        // DATEN HOLEN Nick pls halp
        matchList = mutableListOf(
            Flat(
                "Minden",
                "",
                "gehirnstraße",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                ""
            ),
            Flat(
                "Lübbecke",
                "test",
                "1.0straße",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                ""
            ),
            Flat(
                "Espelkamp",
                "test",
                "Straße",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                ""
            ),
            Flat(
                "Stemwede",
                "test",
                "Straße",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                ""
            ),
            Flat(
                "Hille",
                "test",
                "Straße",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                ""
            ),
            Flat(
                "Bielefeld",
                "test",
                "Straße",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                ""
            ),
            Flat(
                "Hannover",
                "test",
                "Straße",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                ""
            ),
            Flat(
                "Köln",
                "test",
                "Straße",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                ""
            ),
            Flat(
                "Winterfell",
                "test",
                "Straße",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                ""
            ),
            Flat(
                "Ba Sing Se",
                "test",
                "test",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
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