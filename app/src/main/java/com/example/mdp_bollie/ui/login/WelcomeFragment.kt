package com.example.mdp_bollie.ui.login

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.example.mdp_bollie.R
import com.example.mdp_bollie.databinding.FragmentLoginBinding
import com.example.mdp_bollie.databinding.FragmentWelcomeBinding
import com.google.firebase.auth.FirebaseAuth


class WelcomeFragment : Fragment() {

    private lateinit var auth: FirebaseAuth
    private var _binding: FragmentWelcomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentWelcomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Initialize Firebase Auth
        auth = FirebaseAuth.getInstance()

        view.findViewById<Button>(R.id.btn_login).setOnClickListener {
            findNavController().navigate(R.id.action_welcomeFragment_to_loginFragment)
        }
        view.findViewById<Button>(R.id.btn_reg).setOnClickListener {
            findNavController().navigate(R.id.action_welcomeFragment_to_registrationFragment)
        }
    }

    //Check if user loggedIn, then redirect to home page, otherwise navigate to welcome page.
    override fun onStart() {
        val user = auth.currentUser
        super.onStart()

        //If not loggedIn, print not logged in and navigate to welcome page
        if (user == null) {
            Log.d("main", " not logged in ")
        }

        //If logged in, redirect to home page
        if (user != null) {
            Log.d("main", " logged in ")
            findNavController().navigate(R.id.action_welcomeFragment_to_navigation_home)
            reload()
        }
    }

    fun reload() {
    }
}