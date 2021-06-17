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
import com.example.miapp.conexion.Conexion
import com.example.miapp.modelos.Anime
import com.example.miapp.modelos.Cancion

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [musica.newInstance] factory method to
 * create an instance of this fragment.
 */
class musica : Fragment() {
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
        var view = inflater.inflate(R.layout.fragment_musica, container, false)

        var conexion = Conexion(view.context)
        var db = conexion.writableDatabase

        db.execSQL("delete from canciones")

        db.execSQL("insert into canciones (nombre, imagen, descripcion) values('La vuelta al mundo', 'lavuelta.jpg', 'Calle 13')")
        db.execSQL("insert into canciones (nombre, imagen, descripcion) values('I Know where i´ve been', 'iknow.jpg', 'Glee Cast')")
        db.execSQL("insert into canciones (nombre, imagen, descripcion) values('Sangria', 'sangria.jpg', 'Easy Life' )")
        db.execSQL("insert into canciones (nombre, imagen, descripcion) values('Something about us', 'something.jpg','Daft Punk')")
        db.execSQL("insert into canciones (nombre, imagen, descripcion) values('Mouths like side...', 'mouths.jpg', 'The fall of troy')")



        var recyclerView = view.findViewById<RecyclerView>(R.id.rvCanciones)
        recyclerView.layoutManager = LinearLayoutManager(view.context, LinearLayoutManager.VERTICAL, false)
        var canciones=ArrayList<Cancion>()
        var respuesta = db.rawQuery("select * from canciones", null)
        //AQUI LO QUISE HACER CON EL DO WHILE PERO NO SUPE CONVERTIR UN STRING A DRAWABLE O HACER ALGO PARECIDO NO SE SI TENGA ALGUN CONSEJO JIJI
        if(respuesta.moveToFirst()){

            val respuesta1 = db.rawQuery("select * from canciones where imagen='lavuelta.jpg'", null)
            if(respuesta1.moveToFirst()){
                canciones.add(Cancion(respuesta1.getString(1), respuesta1.getString(3), ContextCompat.getDrawable(requireContext(), R.drawable.lavuelta)!!))

            }
            val respuesta2 = db.rawQuery("select * from canciones where imagen='iknow.jpg'", null)
            if(respuesta2.moveToFirst()){
                canciones.add(Cancion(respuesta2.getString(1), respuesta2.getString(3), ContextCompat.getDrawable(requireContext(), R.drawable.iknow)!!))

            }
            val respuesta3 = db.rawQuery("select * from canciones where imagen='sangria.jpg'", null)
            if(respuesta3.moveToFirst()){
                canciones.add(Cancion(respuesta3.getString(1), respuesta3.getString(3), ContextCompat.getDrawable(requireContext(), R.drawable.sangria)!!))

            }
            val respuesta4 = db.rawQuery("select * from canciones where imagen='something.jpg'", null)
            if(respuesta4.moveToFirst()){
                canciones.add(Cancion(respuesta4.getString(1), respuesta4.getString(3), ContextCompat.getDrawable(requireContext(), R.drawable.something)!!))

            }
            val respuesta5 = db.rawQuery("select * from canciones where imagen='mouths.jpg'", null)
            if(respuesta5.moveToFirst()){
                canciones.add(Cancion(respuesta5.getString(1), respuesta5.getString(3), ContextCompat.getDrawable(requireContext(), R.drawable.mouths)!!))

            }




       }else{
           Log.e("DATO", "SIN DATOS" )
      }
        val adapter = AdapterCancion(canciones)
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
         * @return A new instance of fragment musica.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            musica().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}