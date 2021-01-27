package com.example.flatmatch.Presenter

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.EditText
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import com.example.flatmatch.Data.Data
import com.example.flatmatch.Data.User
import com.example.flatmatch.Model.UserModel
import com.example.flatmatch.R
import kotlinx.android.synthetic.main.activitiy_profil.*


class Profil: AppCompatActivity(){

    lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activitiy_profil)

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
                R.id.mFilter -> startActivity(Intent(this, Filter::class.java))
                R.id.mSettings -> startActivity(Intent(this, Settings::class.java))
            }
            true
        }



        var user = Data.getLoggedInUser()
        age_et.setText(user.age.toString())
        name_et.setText(user.firstname.toString())
        lastname_et.setText(user.lastname.toString())
        people_et.setText(user.persons.toString())
        salary_et.setText((user.income.toString()))
        job_et.setText(user.job.toString())

        profil_schufa_cb.isChecked = user.schufa
        pet_cb.isChecked = user.pet

        safe_profil_btn.setOnClickListener {




            val user2:User = User(user.email.toString(), name_et.text.toString(),lastname_et.text.toString(),age_et.text.toString().toInt(), "", salary_et.text.toString().toDouble(), job_et.text.toString(),
            profil_schufa_cb.isChecked, pet_cb.isChecked,  people_et.text.toString().toInt())
            Data.setUser(user2)
            //test.updateUser(user2)

            UserModel.updateUser(user2)
            println(user2)
            startActivity(Intent(this, MainPage::class.java ))
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
