package com.example.miapp.adaptadores


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.miapp.R
import com.example.miapp.modelos.Cancion



class AdapterCancion(val canciones:ArrayList<Cancion>):RecyclerView.Adapter<AdapterCancion.ViewHolder>() {
    var position=-1
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterCancion.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_cancion, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: AdapterCancion.ViewHolder, position: Int) {
        this.position = position
        holder.bindItems(canciones[position])
    }

    override fun getItemCount(): Int {
        return canciones.size
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        init{

        }
        fun bindItems(cancion: Cancion){


            val txtCancion = itemView.findViewById<TextView>(R.id.nombre)
            txtCancion.text=cancion.nombre
            val txtArtista = itemView.findViewById<TextView>(R.id.artista)
            txtArtista.text=cancion.artista
            val ivImagen = itemView.findViewById<ImageView>(R.id.imagen)
            ivImagen.background = cancion.imagen

        }
    }
}