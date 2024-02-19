package com.jhon.educatiomobile.VerifyTeacher

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.jhon.educatiomobile.R

class VerifyTeacherFragment : Fragment() {

    private lateinit var adminSQLOpenHelper: AdminSQLOpenHelper

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_verify_teacher, container, false)

        // Inicializar AdminSQLOpenHelper
        adminSQLOpenHelper = AdminSQLOpenHelper(requireContext())

        // Referenciar elementos de la interfaz de usuario
        val editTextNombreUsuario = view.findViewById<EditText>(R.id.editTextNombreUsuario)
        val editTextContraseña = view.findViewById<EditText>(R.id.editTextContraseña)
        val editTextIdentificacion = view.findViewById<EditText>(R.id.editTextIdentificacion)
        val editTextCorreo = view.findViewById<EditText>(R.id.editTextCorreo)
        val editTextTelefono = view.findViewById<EditText>(R.id.editTextTelefono)
        val editTextHojaVida = view.findViewById<EditText>(R.id.editTextHojaVida)
        val botonVerificarCredenciales = view.findViewById<Button>(R.id.botonVerificarCredenciales)

        // Agregar listener al botón para manejar verificación de credenciales
        botonVerificarCredenciales.setOnClickListener {
            val nombreUsuario = editTextNombreUsuario.text.toString()
            val contraseña = editTextContraseña.text.toString()
            val identificacion = editTextIdentificacion.text.toString()
            val correo = editTextCorreo.text.toString()
            val telefono = editTextTelefono.text.toString()
            val hojaVida = editTextHojaVida.text.toString()

            // Verificar credenciales del docente en la base de datos
            val credencialesValidas = adminSQLOpenHelper.verificarCredencialesDocente(nombreUsuario, contraseña, identificacion, correo, telefono, hojaVida)

            // Mostrar mensaje dependiendo del resultado de la verificación
            if (credencialesValidas) {
                // Credenciales válidas
                Toast.makeText(requireContext(), "Credenciales válidas", Toast.LENGTH_SHORT).show()

                // Aquí puedes iniciar una nueva actividad o navegar a otra pantalla
            } else {
                // Credenciales inválidas
                Toast.makeText(requireContext(), "Credenciales inválidas", Toast.LENGTH_SHORT).show()
            }
        }

        return view
    }
}
