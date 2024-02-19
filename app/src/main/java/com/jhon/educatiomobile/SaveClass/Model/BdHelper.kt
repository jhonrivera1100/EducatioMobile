package com.jhon.educatiomobile.SaveClass.Model

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class BdHelper {
}

class BdHelper(
    context: Context?

) : SQLiteOpenHelper(context, datos.Fecha, null, datos.Materia,null ,datos.Modalidad,null, datos.Nombre_Profesor, null, datos.Nombre_Estudiante, null, datos.Valor) {

    override fun onCreate(p0: SQLiteDatabase?) {

        p0?.execSQL(Constantes.TABLA)
        p0?.execSQL(Constantes.DATA)

    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        p0?.execSQL("DROP TABLE IF EXISTS ciudad")
        onCreate(p0)
    }
}