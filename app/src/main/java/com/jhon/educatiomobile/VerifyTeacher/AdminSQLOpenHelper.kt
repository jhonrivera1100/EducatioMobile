package com.jhon.educatiomobile.VerifyTeacher

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class AdminSQLOpenHelper(context: Context?) : SQLiteOpenHelper(context, NOMBRE_BASE_DATOS, null, VERSION_BASE_DATOS) {

    companion object {
        private const val NOMBRE_BASE_DATOS = "educatiomobile.db"
        private const val VERSION_BASE_DATOS = 1
        private const val TABLA_DOCENTES = "docentes"
        private const val COLUMNA_ID = "id"
        private const val COLUMNA_NOMBRE_COMPLETO = "nombre_completo"
        private const val COLUMNA_NOMBRE_USUARIO = "nombre_usuario"
        private const val COLUMNA_CONTRASEÑA = "contraseña"
        private const val COLUMNA_IDENTIFICACION = "identificacion"
        private const val COLUMNA_CORREO = "correo"
        private const val COLUMNA_TELEFONO = "telefono"
        private const val COLUMNA_HOJA_DE_VIDA = "hoja_de_vida"
    }

    override fun onCreate(db: SQLiteDatabase) {
        val crearTablaDocentes = ("CREATE TABLE $TABLA_DOCENTES ($COLUMNA_ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "$COLUMNA_NOMBRE_COMPLETO TEXT, $COLUMNA_NOMBRE_USUARIO TEXT, $COLUMNA_CONTRASEÑA TEXT, " +
                "$COLUMNA_IDENTIFICACION TEXT, $COLUMNA_CORREO TEXT, $COLUMNA_TELEFONO TEXT, " +
                "$COLUMNA_HOJA_DE_VIDA TEXT)")
        db.execSQL(crearTablaDocentes)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS $TABLA_DOCENTES")
        onCreate(db)
    }
    fun verificarCredencialesDocente(nombreUsuario: String, contraseña: String, identificacion: String, correo: String, telefono: String, hojaVida: String): Boolean {
        val db = this.readableDatabase
        val consulta = "SELECT * FROM $TABLA_DOCENTES WHERE $COLUMNA_NOMBRE_USUARIO = ? AND $COLUMNA_CONTRASEÑA = ? AND $COLUMNA_IDENTIFICACION = ? AND $COLUMNA_CORREO = ? AND $COLUMNA_TELEFONO = ? AND $COLUMNA_HOJA_DE_VIDA = ?"
        val cursor = db.rawQuery(consulta, arrayOf(nombreUsuario, contraseña, identificacion, correo, telefono, hojaVida))
        val cantidad = cursor.count
        cursor.close()
        return cantidad > 0
    }

}
