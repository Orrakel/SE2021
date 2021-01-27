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
import com.example.flatmatch.R
import kotlinx.android.synthetic.main.activitiy_main_page.drawerLayout
import kotlinx.android.synthetic.main.activitiy_main_page.navView
import kotlinx.android.synthetic.main.activitiy_match_list.*
import kotlinx.android.synthetic.main.activity_apartment_list.*

class ApartmentList : AppCompatActivity(), FlatAdapter.OnItemClickListener{

    lateinit var toggle: ActionBarDrawerToggle
    private lateinit var objectList: MutableList<Apartment>

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
                R.id.mHome -> startActivity(Intent(this, MainPage::class.java))
                R.id.mMatches -> startActivity(Intent(this, MatchList::class.java))
                R.id.mObjects -> startActivity(Intent(this, Filter::class.java))
                R.id.mSettings -> startActivity(Intent(this, Settings::class.java))

            }
            true
        }

        objectList = ApartmentModel.getLessorMatches().toMutableList()

        println(objectList)
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

    override fun onItemClick(position: Int) {
        Toast.makeText(this, "Item $position clicked", Toast.LENGTH_SHORT).show()
        val clickedItem = objectList[position]
        Intent(this, MatchShow::class.java).also{
            it.putExtra("position",position)
            startActivity(it)
        }
    }
}