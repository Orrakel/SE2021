package com.example.flatmatch.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.flatmatch.Data.Apartment
import com.example.flatmatch.Data.User
import com.example.flatmatch.R
import kotlinx.android.synthetic.main.item_flat.view.*

class UserAdapter (var users: List<User>, val listener: OnItemClickListener) : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    /**
     * eine innere Klasse die die View speichert von den Einträge
     * @param itemview, die View wie die items dargestellt werden
     */
    inner class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {
        /**
         * initalisiert den setOnClickListener
         */
        init
        {
            itemView.setOnClickListener(this)
        }

        /**
         * fürt bei Clicks auf ein Item die funktion onItemClick() aus
         * @param v, die View wie die items dargestellt werden
         */
        override fun onClick(v: View?) {
            val position = adapterPosition
            if(position != RecyclerView.NO_POSITION) {
                listener.onItemClick(position)
            }
        }
    }

    /**
     * interface um die items anzuklicken.
     *
     */
    interface OnItemClickListener{

        fun onItemClick(position: Int)
    }

    /**
     * beim erstellen der des Viewholder wird die View ermittelt
     * @param parent, die parent vom View
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_flat, parent, false)

        return UserViewHolder(view)
    }

    override fun getItemCount(): Int {
        return users.size
    }

    /**
     * Hier wird die View Formatiert
     * @param holder, die innere klasse
     * @param position, die position vom Item
     */
    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.itemView.apply {
            tvTitle.text = users[position].firstname + ", " + users[position].lastname

        }
    }

}