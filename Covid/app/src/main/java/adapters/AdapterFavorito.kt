package adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.covid.R
import models.Favorito

class AdapterFavorito (val favoritos:ArrayList<Favorito>): RecyclerView.Adapter<AdapterFavorito.ViewHolder>(){
    var position=-1
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterFavorito.ViewHolder {
        var v= LayoutInflater.from(parent.context).inflate(R.layout.item_favorito, parent, false)
        return ViewHolder(v)

    }

    override fun getItemCount(): Int {
        return favoritos.size
    }


    override fun onBindViewHolder(holder: AdapterFavorito.ViewHolder, position: Int) {
        this.position = position
        holder.bindItems(favoritos[position])
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        init {

        }
        fun bindItems(favorito:Favorito){
            val txtFavorito = itemView.findViewById<TextView>(R.id.item_favorito)
            txtFavorito.text= favorito.name
        }
    }
}