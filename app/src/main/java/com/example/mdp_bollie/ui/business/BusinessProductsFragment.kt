package com.example.mdp_bollie.ui.business

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.mdp_bollie.databinding.FragmentBusinesHubBinding
import com.example.mdp_bollie.databinding.FragmentBusinessProductsBinding

class BusinessProductsFragment : Fragment() {
    private var _binding: FragmentBusinessProductsBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBusinessProductsBinding.inflate(inflater, container, false)
        return binding.root
    }
}