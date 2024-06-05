package com.santigp258.easy

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.santigp258.easy.utils.AlertManager
import com.santigp258.easy.utils.AuthManager
import kotlinx.coroutines.launch

class WelcomeFragment : Fragment() {

    private val authManager = AuthManager()
    private lateinit var alertManager: AlertManager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_welcome, container, false)

        alertManager = AlertManager(requireContext(), view)

        val logoutButton = view.findViewById<Button>(R.id.btn_logout)

        logoutButton.setOnClickListener {
            lifecycleScope.launch {
                authManager.signOut()
                alertManager.info("Se ha cerrado sesión")
            }
        }


        return view
    }
}