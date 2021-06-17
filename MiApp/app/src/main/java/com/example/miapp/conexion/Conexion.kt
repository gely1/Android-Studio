package com.example.miapp.conexion

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class Conexion (var contexto: Context): SQLiteOpenHelper(contexto, "miapp", null, 1){

    override fun onCreate(db: SQLiteDatabase?) {
        val tablaCanciones = "CREATE TABLE canciones(id Integer not null primary key autoincrement, " +
                " nombre varchar(100)," +
                " imagen varchar(100)," +
                " descripcion varchar(100))"
            db?.execSQL(tablaCanciones)

        val tablaAnimes = "CREATE TABLE animes(id Integer not null primary key autoincrement, " +
                " nombre varchar(100)," +
                " imagen varchar(100)," +
                " descripcion varchar(100))"
             db?.execSQL(tablaAnimes)

        val tablaRandom = "CREATE TABLE random(id Integer not null primary key autoincrement, " +
                " nombre varchar(100)," +
                " imagen varchar(100)," +
                " descripcion varchar(100))"
            db?.execSQL(tablaRandom)
    }


    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("Not yet implemented")
    }
}