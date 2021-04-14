package com.example.mdp_bollie.ui.business

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.mdp_bollie.R
import com.example.mdp_bollie.databinding.FragmentBusinesHubBinding

class BusinesHubFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var _binding: FragmentBusinesHubBinding? = null
    private val binding get() = _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBusinesHubBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val navController = findNavController()
        binding.btnBestellingen2.setOnClickListener {
            navController.navigate(R.id.action_navigation_businessHub_to_businessBestellingenFragment)
        }
        binding.btnKlantvragen2.setOnClickListener {
            navController.navigate(R.id.action_navigation_businessHub_to_businessKlantvragenFragment)
        }
        binding.btnRetouren2.setOnClickListener {
            navController.navigate(R.id.action_navigation_businessHub_to_businessBestellingenFragment)
        }
        binding.btnOmzet2.setOnClickListener {
            navController.navigate(R.id.action_navigation_businessHub_to_businessFinancienFragment)
        }
    }
}