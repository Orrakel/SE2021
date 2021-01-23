package com.example.flatmatch.Presenter

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.view.animation.LinearInterpolator
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.DiffUtil
import com.example.flatmatch.Model.CardStackAdapter
import com.example.flatmatch.Model.CardStackCallback
import com.example.flatmatch.Model.ItemModel
import com.example.flatmatch.R
import com.yuyakaido.android.cardstackview.*
import kotlinx.android.synthetic.main.activitiy_main_page.*
import java.util.*

class MainPage : AppCompatActivity(){


    lateinit var toggle: ActionBarDrawerToggle
    private val TAG ="MainPage"
    private lateinit var manager: CardStackLayoutManager
    private lateinit var adapter: CardStackAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activitiy_main_page)



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

        val cardStackView: CardStackView = findViewById(R.id.card_stack_view)
//        manager = CardStackLayoutManager(this, new CardStackListener() {
//
//        })
        manager = CardStackLayoutManager(this, object : CardStackListener {
            override fun onCardDragging(direction: Direction, ratio: Float) {
                Log.d(TAG, "onCardDragging: d=" + direction.name + " ratio=" + ratio)
            }

            override fun onCardSwiped(direction: Direction) {
                Log.d(TAG, "onCardSwiped: p=" + manager.topPosition + " d=" + direction)
                if (direction == Direction.Right) {
                    Toast.makeText(this@MainPage, "Direction Right", Toast.LENGTH_SHORT).show()
                }
                if (direction == Direction.Top) {
                    Toast.makeText(this@MainPage, "Direction Top", Toast.LENGTH_SHORT).show()
                }
                if (direction == Direction.Left) {
                    Toast.makeText(this@MainPage, "Direction Left", Toast.LENGTH_SHORT).show()
                }
                if (direction == Direction.Bottom) {
                    Toast.makeText(this@MainPage, "Direction Bottom", Toast.LENGTH_SHORT).show()
                }

                // Paginating
                if (manager.topPosition == adapter.itemCount - 5) {
                    paginate()
                }
            }

            override fun onCardRewound() {
                Log.d(TAG, "onCardRewound: " + manager.topPosition)
            }

            override fun onCardCanceled() {
                Log.d(TAG, "onCardRewound: " + manager.topPosition)
            }

            override fun onCardAppeared(view: View, position: Int) {
                val tv = view.findViewById<TextView>(R.id.item_name)
                Log.d(TAG, "onCardAppeared: " + position + ", nama: " + tv.text)
            }

            override fun onCardDisappeared(view: View, position: Int) {
                val tv = view.findViewById<TextView>(R.id.item_name)
                Log.d(TAG, "onCardAppeared: " + position + ", nama: " + tv.text)
            }
        })

        manager.setStackFrom(StackFrom.None)
        manager.setVisibleCount(3)
        manager.setTranslationInterval(8.0f)
        manager.setScaleInterval(0.95f)
        manager.setSwipeThreshold(0.3f)
        manager.setMaxDegree(20.0f)
        manager.setDirections(Direction.FREEDOM)
        manager.setCanScrollHorizontal(true)
        manager.setSwipeableMethod(SwipeableMethod.Manual)
        manager.setOverlayInterpolator(LinearInterpolator())
        adapter = CardStackAdapter(addList())
        cardStackView.layoutManager = manager
        cardStackView.adapter = adapter
        cardStackView.itemAnimator = DefaultItemAnimator()

    }

    private fun paginate() {
        val old: List<ItemModel> = adapter.items
        val baru: List<ItemModel> = ArrayList<ItemModel>(addList())
        val callback = CardStackCallback(old, baru)
        val hasil = DiffUtil.calculateDiff(callback)
        adapter.items = baru
        hasil.dispatchUpdatesTo(adapter)
    }

    private fun addList(): List<ItemModel>? {
        val items: MutableList<ItemModel> = ArrayList()
        items.add(ItemModel(R.drawable.sample1, "Markonah", "24", "Jember"))
        items.add(ItemModel(R.drawable.sample2, "Marpuah", "20", "Malang"))
        items.add(ItemModel(R.drawable.sample3, "Sukijah", "27", "Jonggol"))
        items.add(ItemModel(R.drawable.sample4, "Markobar", "19", "Bandung"))
        items.add(ItemModel(R.drawable.sample5, "Marmut", "25", "Hutan"))
        items.add(ItemModel(R.drawable.sample1, "Markonah", "24", "Jember"))
        items.add(ItemModel(R.drawable.sample2, "Marpuah", "20", "Malang"))
        items.add(ItemModel(R.drawable.sample3, "Sukijah", "27", "Jonggol"))
        items.add(ItemModel(R.drawable.sample4, "Markobar", "19", "Bandung"))
        items.add(ItemModel(R.drawable.sample5, "Marmut", "25", "Hutan"))
        return items
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if(toggle.onOptionsItemSelected(item))
        {
            return true
        }
        return super.onOptionsItemSelected(item)
    }

}