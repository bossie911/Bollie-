package com.example.mdp_bollie.ui.notifications

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.mdp_bollie.R
import com.example.mdp_bollie.databinding.FragmentBusinesHubBinding
import com.example.mdp_bollie.databinding.FragmentUserHubBinding
import com.example.mdp_bollie.databinding.FragmentUserProfileBinding
import com.google.firebase.auth.FirebaseAuth

class UserHubFragment : Fragment() {

    private lateinit var auth: FirebaseAuth
    private var _binding: FragmentUserHubBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentUserHubBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val navController = findNavController()

        // Initialize Firebase Auth
        auth = FirebaseAuth.getInstance()

        //Button navigation
        binding.buttonProfiel.setOnClickListener {
            navController.navigate(R.id.action_navigation_settings_to_userProfielFragment)
        }
        binding.buttonProfiel2.setOnClickListener {
            navController.navigate(R.id.action_navigation_settings_to_userProfielFragment)
        }
        binding.buttonSettings.setOnClickListener {
            navController.navigate(R.id.action_userHubFragment_to_userSettingsFragment)
        }
        binding.buttonSettings2.setOnClickListener {
            navController.navigate(R.id.action_userHubFragment_to_userSettingsFragment)
        }
        binding.buttonSupport.setOnClickListener {
            navController.navigate(R.id.action_navigation_settings_to_userSupportFragment)
        }
        binding.buttonSupport2.setOnClickListener {
            navController.navigate(R.id.action_navigation_settings_to_userSupportFragment)
        }

        view.findViewById<Button>(R.id.btn_logout).setOnClickListener {
            logoutUser()
        }
    }

    private fun logoutUser() {
        auth.signOut()
        Toast.makeText(context, getString(R.string.uitgelogd), Toast.LENGTH_SHORT).show()
        findNavController().navigate(R.id.action_userHubFragment_to_loginFragment)
    }

}