package com.example.flatmatch.Presenter

import com.example.flatmatch.Adapter.UserAdapter
import com.example.flatmatch.Data.User
import kotlinx.android.synthetic.main.activity_match_list_lessor.*
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.flatmatch.Data.Data
import com.example.flatmatch.Model.LessorModel
import com.example.flatmatch.R


/**
 * Soll alle matchesw anzeigen. aufgrund fehlender Daten werden alle Objekte angezeigt
 */
class MatchList_Lessor : AppCompatActivity(), UserAdapter.OnItemClickListener{

    lateinit var toggle: ActionBarDrawerToggle
    private lateinit var matchList: MutableList<User>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_match_list_lessor)

        toggle = ActionBarDrawerToggle(this, matchListLessor_drawerLayout,
                R.string.open,
                R.string.close
        )
        matchListLessor_drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        matchListLessor_navView.setNavigationItemSelectedListener {
            when(it.itemId)
            {
                R.id.mHome -> startActivity(Intent(this, MainPage_Lessor::class.java))
                R.id.mMatches -> startActivity(Intent(this, MatchList_Lessor::class.java))
                R.id.mObjects -> startActivity(Intent(this, ApartmentList::class.java))
                R.id.mSettings -> startActivity(Intent(this, SettingsLessor::class.java))
            }
            true
        }
        matchList = ArrayList<User>()
        matchList = LessorModel.getMatchesFromApartment(Data.getApartment())
        //matchList.add(User("anolting@e-mail.de", "Alex", "Sucher", 27, "test", 1000.0, "bubun", true, true, 1))
        println(matchList)
        val adapter = UserAdapter(matchList, this)
        rvMatches_matchListLessor.adapter = adapter
        rvMatches_matchListLessor.layoutManager = LinearLayoutManager(this)



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
     * Beim klicken auf das item wird ein neuer Page geöffnet und übergibt die Position vom Objekt
     * @param position, position in der Liste vom Objekt
     */
    override fun onItemClick(position: Int) {
        Toast.makeText(this, "Item $position clicked", Toast.LENGTH_SHORT).show()
        val clickedItem = matchList[position]
        Intent(this, MatchShow_Lessor::class.java).also{
            it.putExtra("position",position)
            startActivity(it)
        }

    }
}