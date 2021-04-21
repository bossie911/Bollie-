package com.example.mdp_bollie.ui.notifications

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.mdp_bollie.databinding.FragmentUserProfileBinding
import com.example.mdp_bollie.databinding.FragmentUserSettingsBinding

class UserSettingsFragment: Fragment() {
    private var _binding: FragmentUserSettingsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentUserSettingsBinding.inflate(inflater, container, false)
        return binding.root
    }
}