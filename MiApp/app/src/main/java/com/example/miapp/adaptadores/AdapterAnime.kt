package com.example.miapp.adaptadores

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.miapp.R
import com.example.miapp.modelos.Anime


class AdapterAnime(val animes:ArrayList<Anime>):RecyclerView.Adapter<AdapterAnime.ViewHolder>() {
    var position=-1
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterAnime.ViewHolder {
        var v = LayoutInflater.from(parent.context).inflate(R.layout.item_anime, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: AdapterAnime.ViewHolder, position: Int) {
        this.position = position
        holder.bindItems(animes[position])
    }

    override fun getItemCount(): Int {
        return animes.size
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        init{

        }
        fun bindItems(anime: Anime){
            val txtAnime = itemView.findViewById<TextView>(R.id.anime)
            txtAnime.text=anime.nombre
            val txtDescripcion = itemView.findViewById<TextView>(R.id.descripcion)
            txtDescripcion.text=anime.descripcion
            val ivImagena = itemView.findViewById<ImageView>(R.id.imagena)
            ivImagena.background = anime.imagen
        }
    }
}