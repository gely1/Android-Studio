package com.example.miapp

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.miapp.adaptadores.AdapterAnime
import com.example.miapp.adaptadores.AdapterCancion
import com.example.miapp.conexion.Conexion
import com.example.miapp.modelos.Anime
import com.example.miapp.modelos.Cancion

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [anime.newInstance] factory method to
 * create an instance of this fragment.
 */
class anime : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {




        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_anime, container, false)

        var conexion = Conexion(view.context)
        var db = conexion.writableDatabase

        db.execSQL("delete from animes")
        db.execSQL("insert into animes (nombre, imagen, descripcion) values('Jujutsu Kaisen', 'jujutsu.jpg', 'Este anime tiene una excelente animación, una excelente historia y personajes agradables')")
        db.execSQL("insert into animes (nombre, imagen, descripcion) values('Corpse Party', 'corpse.jpg', 'Este anime es muy sangriento y no tiene un final feliz')")
        db.execSQL("insert into animes (nombre, imagen, descripcion) values('Boku no Hero', 'boku.jpg', 'Anime muy bonito, con personajes increibles y poderosos y una historia muy padre' )")
        db.execSQL("insert into animes (nombre, imagen, descripcion) values('Shingeki no Kyojin', 'shingeki.jpg','Este es muy sangriento y sádico, con un giro a la trama que lo hace muy bueno')")
        db.execSQL("insert into animes (nombre, imagen, descripcion) values('Yakusoku no Neverland', 'yakusoku.jpg', 'Y este anime trata de una granja de niños en un pseudo mundo en donde existen monstruos come humanos')")



        var recyclerView = view.findViewById<RecyclerView>(R.id.rvAnimes)
        recyclerView.layoutManager = LinearLayoutManager(view.context, LinearLayoutManager.VERTICAL, false)
        var animes=ArrayList<Anime>()
        var respuesta = db.rawQuery("select * from animes", null)

        if(respuesta.moveToFirst()){

            val respuesta1 = db.rawQuery("select * from animes where imagen='jujutsu.jpg'", null)
            if(respuesta1.moveToFirst()){
                animes.add(Anime(respuesta1.getString(1), respuesta1.getString(3), ContextCompat.getDrawable(requireContext(), R.drawable.jujutsu)!!))

            }
            val respuesta2 = db.rawQuery("select * from animes where imagen='corpse.jpg'", null)
            if(respuesta2.moveToFirst()){
                animes.add(Anime(respuesta2.getString(1), respuesta2.getString(3), ContextCompat.getDrawable(requireContext(), R.drawable.corpse)!!))

            }
            val respuesta3 = db.rawQuery("select * from animes where imagen='boku.jpg'", null)
            if(respuesta3.moveToFirst()){
                animes.add(Anime(respuesta3.getString(1), respuesta3.getString(3), ContextCompat.getDrawable(requireContext(), R.drawable.boku)!!))

            }
            val respuesta4 = db.rawQuery("select * from animes where imagen='shingeki.jpg'", null)
            if(respuesta4.moveToFirst()){
                animes.add(Anime(respuesta4.getString(1), respuesta4.getString(3), ContextCompat.getDrawable(requireContext(), R.drawable.shingeki)!!))

            }
            val respuesta5 = db.rawQuery("select * from animes where imagen='yakusoku.jpg'", null)
            if(respuesta5.moveToFirst()){
                animes.add(Anime(respuesta5.getString(1), respuesta5.getString(3), ContextCompat.getDrawable(requireContext(), R.drawable.yakusoku)!!))

            }




        }else{
            Log.e("DATO", "SIN DATOS" )
        }
        val adapter = AdapterAnime(animes)
        recyclerView.adapter = adapter


        return view


    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment anime.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            anime().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}