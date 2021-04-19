package com.example.mdp_bollie.ui.notifications

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.mdp_bollie.R
import com.example.mdp_bollie.databinding.FragmentBusinesHubBinding
import com.example.mdp_bollie.databinding.FragmentUserHubBinding
import com.example.mdp_bollie.databinding.FragmentUserProfileBinding

class UserHubFragment : Fragment() {

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

        //Button navigation
        binding.buttonProfiel.setOnClickListener {
            navController.navigate(R.id.action_navigation_settings_to_userProfielFragment)
        }
        binding.buttonSettings.setOnClickListener {
            navController.navigate(R.id.action_userHubFragment_to_userSettingsFragment)
        }
        binding.buttonSupport.setOnClickListener {
            navController.navigate(R.id.action_navigation_settings_to_userSupportFragment)
        }
    }
}