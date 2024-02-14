package com.jhon.educatiomobile.Register

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jhon.educatiomobile.R
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper


//es la clase que  crea y actualiza la BD

class AdminSQLOpenHelper( // se define un constructor con 4 parametros
    context: Context?,
    name: String?,
    factory: SQLiteDatabase.CursorFactory?,
    version: Int
) : SQLiteOpenHelper(context, name, factory, version) {

    //es un método que se llama automáticamente cuando se crea la base de datos por primera vez.
    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL("create table admin(usuario text primary key,password text)") //tabla del admin
        val usuario = "admin"
        val password = "12345"
        val datosAdmin = ContentValues()
        datosAdmin.put("usuario", usuario) //agrega un par clave-valor a un objeto
        datosAdmin.put("password", password)
        db.insert("admin", "(usuario,password)", datosAdmin)//hacemos una inserción
        db.execSQL("create table usuarios(cedula int primary key,nombres text,nacimiento text," +
                "ciudad text,telefono int,correo  text,clave password)")
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        // No se realiza ninguna acción en la actualización de la base de datos
    }}