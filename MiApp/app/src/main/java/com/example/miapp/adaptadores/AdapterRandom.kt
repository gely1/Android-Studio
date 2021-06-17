package com.example.miapp.adaptadores

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.miapp.R
import com.example.miapp.modelos.Random


class AdapterRandom(val videos:ArrayList<Random>): RecyclerView.Adapter<AdapterRandom.ViewHolder>() {
    var position=-1
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterRandom.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_random, parent, false)
        return AdapterRandom.ViewHolder(v)
    }

    override fun onBindViewHolder(holder: AdapterRandom.ViewHolder, position: Int) {
        this.position = position
        holder.bindItems(videos[position])
    }

    override fun getItemCount(): Int {
        return videos.size
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        init{

        }
        fun bindItems(random: Random){


            val txtNombre = itemView.findViewById<TextView>(R.id.nombrer)
            txtNombre.text=random.nombre
            val txtDescripcion = itemView.findViewById<TextView>(R.id.descripcionr)
            txtDescripcion.text=random.descripcion
            val iRandom = itemView.findViewById<ImageView>(R.id.ivRandom)
            iRandom.background = random.imagen

        }
    }

}