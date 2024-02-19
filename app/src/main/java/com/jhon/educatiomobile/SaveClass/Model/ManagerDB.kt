package com.jhon.educatiomobile.SaveClass.Model

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase

class ManagerDB {
}

data class ManagerBD (val context: Context){

    lateinit var p0: SQLiteDatabase


    val BdHelper = BdHelper(context)// LLAMANDO CONEXION BASE DE DATOS

    fun openBdWr (){

        p0 = BdHelper.writableDatabase
    }

    fun openBdRd(){

        p0 = BdHelper.writableDatabase

    }
    @SuppressLint("SuspiciousIndentation")
    fun insertData(): Long {
        openBdWr() // abrir db en modo escritura
        //Creo contenedor de valores para insertar data
        val contenedor = ContentValues()
       // contenedor.put("cod",1 )
        // contenedor.put("nombre","cali")
        // contenedor.put("codeDep",25)
        //Llamo metodo

        val resul = p0.insert("ciudad",null,contenedor)

        return  resul