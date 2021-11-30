package com.example.starwarsdatabase.main.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.starwarsdatabase.R
import com.example.starwarsdatabase.api.Characters
import com.example.starwarsdatabase.main.view.HomeFragmentDirections
import kotlinx.android.synthetic.main.item_starwars.view.*

class AdapterStarWars(var characters: Characters) :
    RecyclerView.Adapter<AdapterStarWars.DatabaseViewHolder>() {

    class DatabaseViewHolder(var view: View) : RecyclerView.ViewHolder(view) {

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DatabaseViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_starwars, parent, false)
        return DatabaseViewHolder(view)
    }

    override fun onBindViewHolder(holder: DatabaseViewHolder, position: Int) {
        val charName = holder.view.tvCharName
        val responseModel = characters.results?.get(position)
        charName.text = responseModel!!.name
        charName.setOnClickListener {
            val action =
                HomeFragmentDirections.actionHomeFragmentToDetailFragment(responseModel.uid)
            Navigation.findNavController(charName).navigate(action)
        }
    }

    override fun getItemCount(): Int {
        return characters.results!!.size
    }


}