package com.jhon.educatiomobile.Login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
<<<<<<< HEAD
import com.jhon.educatiomobile.R


class LoginFragment : Fragment() {

}
=======
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.jhon.educatiomobile.R

class LoginFragment : Fragment() {

    private lateinit var editTextEmail: EditText
    private lateinit var editTextPassword: EditText
    private lateinit var buttonLogin: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        editTextEmail = view.findViewById(R.id.editTextTextEmailAddress)
        editTextPassword = view.findViewById(R.id.editTextNumberPassword)
        buttonLogin = view.findViewById(R.id.bottonInicioDeSesion)

        buttonLogin.setOnClickListener {
            val email = editTextEmail.text.toString().trim()
            val password = editTextPassword.text.toString().trim()

            if (email.isNotEmpty() && password.isNotEmpty()) {
                // Aquí puedes agregar la lógica para verificar las credenciales y realizar el inicio de sesión
                // Por ahora, simplemente mostraremos un mensaje de inicio de sesión exitoso
                Toast.makeText(requireContext(), "Inicio de sesión exitoso", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(requireContext(), "Por favor, completa todos los campos", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
>>>>>>> origin/login
