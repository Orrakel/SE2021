package com.example.flatmatch.Presenter

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import butterknife.ButterKnife
import com.example.flatmatch.Data.Apartment
import com.example.flatmatch.Data.Data
import com.example.flatmatch.Data.User
import com.example.flatmatch.Model.ApartmentModel
import com.example.flatmatch.Model.LessorModel
import com.example.flatmatch.Model.UserModel
import com.example.flatmatch.R
import com.lorentzos.flingswipe.SwipeFlingAdapterView
import kotlinx.android.synthetic.main.activitiy_main_page_lessor.*

class MainPage_Lessor  : AppCompatActivity(){


    lateinit var toggle: ActionBarDrawerToggle


    lateinit var users: ArrayList<User>
    lateinit var arrayAdapter: ArrayAdapter<User>


    /**
     * erstellung der Mainpage für den Vermieter
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


            setContentView(R.layout.activitiy_main_page_lessor)
            toggle = ActionBarDrawerToggle(this, drawerLayout,
                    R.string.open,
                    R.string.close
            )
            drawerLayout.addDrawerListener(toggle)
            toggle.syncState()

            supportActionBar?.setDisplayHomeAsUpEnabled(true)

            navView.setNavigationItemSelectedListener {
                when (it.itemId) {
                    R.id.mObjects -> startActivity(Intent(this, ApartmentList::class.java))
                    R.id.mMatches -> startActivity(Intent(this, MatchList_Lessor::class.java))
                    R.id.mSettings -> startActivity(Intent(this, SettingsLessor::class.java))
                    R.id.mHome -> startActivity(Intent(this, MainPage_Lessor::class.java))
                }
                true
            }

        ButterKnife.inject(this)
        users = java.util.ArrayList<User>()

            println("MainPage_Lessor: " + Data.getApartment())


        users = LessorModel.getLikesFromApartment(Data.getApartment())
        println(users)
        arrayAdapter = ArrayAdapter(this, R.layout.item, R.id.helloText, users)

        val flingContainer: SwipeFlingAdapterView = findViewById(R.id.frame)
        flingContainer.setAdapter(arrayAdapter)
        flingContainer.setFlingListener(object : SwipeFlingAdapterView.onFlingListener {
            lateinit var  userBefore: User

            /**
             * beim entfernen einer karte sspeichert er den entfernten Karte in userBefore
             */
            override fun removeFirstObjectInAdapter() {
                // this is the simplest way to delete an object from the Adapter (/AdapterView)
                Log.d("LIST", "removed object!")
                userBefore = users[0]
                users.removeAt(0)
                arrayAdapter.notifyDataSetChanged()
            }

            /**
             * bei nach links swipen speichert er den like
             */
            override fun onLeftCardExit(dataObject: Any) {
                flingContainer.selectedItemPosition
                Toast.makeText(this@MainPage_Lessor, "Like! ", Toast.LENGTH_SHORT).show()

                println(userBefore.firstname)
                //ApartmentModel.insertMatch(Data.getApartment())
                Data.setUser(userBefore)
                ApartmentModel.insertMatch(Data.getApartment())
                Data.setUser(null)
            }

            /**
             * macht er nichts
             */
            override fun onRightCardExit(dataObject: Any) {
                Toast.makeText(this@MainPage_Lessor, "Dislike!", Toast.LENGTH_SHORT).show()
            }

            /**
             * macht er nichts
             */
            override fun onAdapterAboutToEmpty(itemsInAdapter: Int) {
                // Ask for more data her
                arrayAdapter.notifyDataSetChanged()

                Log.d("LIST", "notified")

            }

            /**
             * macht er nichts
             */
            override fun onScroll(scrollProgressPercent: Float) {

            }
        })

        // Optionally add an OnItemClickListener
        flingContainer.setOnItemClickListener(
                object : SwipeFlingAdapterView.OnItemClickListener {
                    lateinit var dialogBuilder: AlertDialog.Builder
                    lateinit var  dialog: AlertDialog
                    lateinit var firstname: TextView
                    lateinit var lastname: TextView
                    lateinit var persons: TextView
                    lateinit var income: TextView
                    lateinit var job: TextView
                    lateinit var age: TextView
                    lateinit var pet: TextView
                    lateinit var schufa: TextView
                    lateinit var btn_cancel: Button
                    override fun onItemClicked(itemPosition: Int, dataObject: Any) {



                        dialogBuilder = AlertDialog.Builder(this@MainPage_Lessor)
                        val popUpView: View = layoutInflater.inflate(R.layout.popup_menu, null)
                        firstname = popUpView.findViewById(R.id.popUp_city)
                        lastname = popUpView.findViewById(R.id.popUp_cost)
                        persons = popUpView.findViewById(R.id.popUp_rooms)
                        income = popUpView.findViewById(R.id.popUp_zip)
                        job = popUpView.findViewById(R.id.popUp_street)
                        age = popUpView.findViewById(R.id.popUp_houseNumber)
                        pet = popUpView.findViewById(R.id.popUp_size)
                        schufa = popUpView.findViewById(R.id.popUp_arePetsAllowed)
                        btn_cancel = popUpView.findViewById(R.id.popUp_btn_cancel)


                        firstname.text = "Stadt: " + users.get(itemPosition).firstname
                        lastname.text = "Kosten: " + users.get(itemPosition).lastname.toString()
                        persons.text = "PLZ: " + users.get(itemPosition).persons.toString()
                        income.text = "Straße: " + users.get(itemPosition).income.toString()
                        job.text = "Hausnummer: " + users.get(itemPosition).job
                        age.text = "Größe: " + users.get(itemPosition).age.toString()
                        pet.text = "Haustiere: " + users.get(itemPosition).pet.toString()
                        schufa.text = "Commercial Usage: " + users.get(itemPosition).schufa.toString()


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

}