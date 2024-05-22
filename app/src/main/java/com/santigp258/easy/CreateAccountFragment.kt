package com.santigp258.easy

import android.app.AlertDialog
import android.os.Bundle
import android.util.Patterns
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController


class CreateAccountFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_create_account, container, false)

        val doneButton = view.findViewById<Button>(R.id.btn_done)
        val cancelButton = view.findViewById<TextView>(R.id.btn_cancel)

        val emailEditText = view.findViewById<EditText>(R.id.email)
        val passwordEditText = view.findViewById<EditText>(R.id.password)
        val phoneEditText = view.findViewById<EditText>(R.id.phone)



        doneButton.setOnClickListener {
            val email = emailEditText.text.toString().trim()
            val password = passwordEditText.text.toString().trim()
            val phone = phoneEditText.text.toString().trim()

            if (validateForm(email, password, phone)) {
                this.showAlert()
            }
        }

        cancelButton.setOnClickListener {
            findNavController().popBackStack()
        }

        return view
    }

    private fun showAlert() {
        val builder = AlertDialog.Builder(requireContext())
        builder.setTitle("Perfecto")
        builder.setMessage("Se Registro!")
        builder.setPositiveButton("Ir al login") { dialog, which ->
            findNavController().navigate(R.id.action_createAccountFragment_to_loginFragment)
        }
        builder.setNegativeButton("Cancelar") { dialog, which ->
            // Action
        }
        builder.show()
    }


    private fun validateForm(email: String, password: String, phone: String): Boolean {
        var isValid = true

        if (email.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            isValid = false
            showError("Por favor ingrese un correo electrónico válido")
        }

        if (password.isEmpty() || password.length < 6) {
            isValid = false
            showError("La contraseña debe tener al menos 6 caracteres")
        }

        if (phone.isEmpty() || !Patterns.PHONE.matcher(phone).matches()) {
            isValid = false
            showError("Por favor ingrese un número de teléfono válido")
        }

        return isValid
    }

    private fun showError(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }

}