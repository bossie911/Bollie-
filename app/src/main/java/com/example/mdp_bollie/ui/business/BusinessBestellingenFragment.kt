package com.example.mdp_bollie.ui.business

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.mdp_bollie.databinding.FragmentBusinesHubBinding
import com.example.mdp_bollie.databinding.FragmentBusinessBestellingenBinding
import com.example.mdp_bollie.ui.BestellingViewModel

class BusinessBestellingenFragment : Fragment() {
    private var _binding: FragmentBusinessBestellingenBinding? = null
    private val binding get() = _binding!!

    private val viewModel: BestellingViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBusinessBestellingenBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.floatingActionButton.setOnClickListener {
            viewModel.getToken()
        }
        observeToken()
    }

    private fun observeToken() {
        viewModel.trivia.observe(viewLifecycleOwner, {
            binding.tvTokenTest.text = it?.access_token
        })

        // Observe the error message.
        viewModel.errorText.observe(viewLifecycleOwner, {
            Toast.makeText(activity, it, Toast.LENGTH_SHORT).show()
        })
    }
}
