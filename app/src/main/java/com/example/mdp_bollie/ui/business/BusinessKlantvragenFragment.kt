package com.example.mdp_bollie.ui.business

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.mdp_bollie.databinding.FragmentBusinessKlantvragenBinding
import com.example.mdp_bollie.databinding.FragmentBusinessProductsBinding

class BusinessKlantvragenFragment: Fragment() {
    private var _binding: FragmentBusinessKlantvragenBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBusinessKlantvragenBinding.inflate(inflater, container, false)
        return binding.root
    }
}