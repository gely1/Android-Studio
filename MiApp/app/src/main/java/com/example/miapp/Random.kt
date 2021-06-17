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
import com.example.miapp.adaptadores.AdapterCancion
import com.example.miapp.adaptadores.AdapterRandom
import com.example.miapp.conexion.Conexion
import com.example.miapp.modelos.Cancion
import com.example.miapp.modelos.Random

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [random.newInstance] factory method to
 * create an instance of this fragment.
 */
class random : Fragment() {
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
        var view = inflater.inflate(R.layout.fragment_random, container, false)

        var conexion = Conexion(view.context)
        var db = conexion.writableDatabase

        db.execSQL("delete from random")
        db.execSQL("insert into random (nombre, imagen, descripcion) values('El pulso de la república', 'pulso.jpg', 'Noticias semanales acerca de acontecimientos gubernamentales en todo México, mezclado con mucho humor negro')")
        db.execSQL("insert into random (nombre, imagen, descripcion) values('Kurtis Conner', 'kurtis.jpg', 'Comediante de Canadá que hace muy buen contenido')")
        db.execSQL("insert into random (nombre, imagen, descripcion) values('Jacobo Wong', 'jacobo.jpg', 'Tu dosis diaria de información. Estas son noticias pero son más generales e internacionales' )")



        var recyclerView = view.findViewById<RecyclerView>(R.id.rvRandom)
        recyclerView.layoutManager = LinearLayoutManager(view.context, LinearLayoutManager.VERTICAL, false)
        var videos=ArrayList<Random>()
        var respuesta = db.rawQuery("select * from random", null)
        if(respuesta.moveToFirst()){

            val respuesta1 = db.rawQuery("select * from random where imagen='pulso.jpg'", null)
            if(respuesta1.moveToFirst()){
                videos.add(Random(respuesta1.getString(1), respuesta1.getString(3), ContextCompat.getDrawable(requireContext(), R.drawable.pulso)!!))

            }
            val respuesta2 = db.rawQuery("select * from random where imagen='kurtis.jpg'", null)
            if(respuesta2.moveToFirst()){
                videos.add(Random(respuesta2.getString(1), respuesta2.getString(3), ContextCompat.getDrawable(requireContext(), R.drawable.kurtis)!!))

            }
            val respuesta3 = db.rawQuery("select * from random where imagen='jacobo.jpg'", null)
            if(respuesta3.moveToFirst()){
                videos.add(Random(respuesta3.getString(1), respuesta3.getString(3), ContextCompat.getDrawable(requireContext(), R.drawable.jacobo)!!))

            }

        }else{
            Log.e("DATO", "SIN DATOS" )
        }
        val adapter = AdapterRandom(videos)
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
         * @return A new instance of fragment random.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            random().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}