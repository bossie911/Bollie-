package com.example.mdp_bollie.ui.business

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.mdp_bollie.R
import com.example.mdp_bollie.databinding.FragmentBusinesHubBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [BusinesHubFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
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
//        binding.btnBestellingen2.setOnClickListener {
//            findNavController().navigate(R.id.action_businesHubFragment_to_businessBestellingenFragment2)
//        }
        binding.btnKlantvragen2.setOnClickListener {

        }
        binding.btnRetouren2.setOnClickListener {

        }
    }
}