package com.example.simplegetrequest

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.simplegetrequest.databinding.ItemPokeBinding
import org.json.JSONArray
import org.json.JSONObject

class Main_Adapter(private val pokemon: JSONArray): RecyclerView.Adapter<Main_Adapter.MainHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Main_Adapter.MainHolder {
        val binding = ItemPokeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MainHolder(binding)
    }

    override fun onBindViewHolder(holder: Main_Adapter.MainHolder, position: Int) {
        holder.render(pokemon.getJSONObject(position))
    }

    override fun getItemCount(): Int = pokemon.length()

    class MainHolder(val binding: ItemPokeBinding): RecyclerView.ViewHolder(binding.root){

        fun render(poke: JSONObject){
            binding.textView.setText(poke.getString("name"))
        }
    }
}