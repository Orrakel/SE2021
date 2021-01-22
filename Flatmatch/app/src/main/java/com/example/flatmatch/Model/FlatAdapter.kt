package com.example.flatmatch.Model

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.flatmatch.Data.Flat
import com.example.flatmatch.R
import kotlinx.android.synthetic.main.item_flat.view.*

class FlatAdapter(var flats: List<Flat>, val listener: OnItemClickListener) : RecyclerView.Adapter<FlatAdapter.FlatViewHolder>() {

    inner class FlatViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
    View.OnClickListener {
        init
        {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position = adapterPosition
            if(position != RecyclerView.NO_POSITION) {
                listener.onItemClick(position)
            }
        }
    }
    interface OnItemClickListener{

        fun onItemClick(position: Int)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FlatViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_flat, parent, false)

        return FlatViewHolder(view)
    }

    override fun getItemCount(): Int {
        return flats.size
    }

    override fun onBindViewHolder(holder: FlatViewHolder, position: Int) {
        holder.itemView.apply {
            tvTitle.text = flats[position].city + ", " + flats[position].street

        }
    }
}