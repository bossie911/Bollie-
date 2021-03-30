package com.example.mdp_bollie.ui.home

import android.icu.util.Calendar
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation.findNavController
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.mdp_bollie.R
import com.example.mdp_bollie.databinding.FragmentHomeBinding
import java.text.SimpleDateFormat
import java.util.*


class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val topics = arrayListOf<Topic>()
    private val topicAdapter = TopicAdapter(topics)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val navController = findNavController(requireActivity(), R.id.nav_host_fragment)

        binding.stimulationBtn.setOnClickListener{
            navController.navigate(R.id.action_navigation_home_to_businesHubFragment)

        }
        for (i in Topic.NAMES.indices){
            topics.add(
                    Topic(Topic.NAMES[i])
            )
        }
        topicAdapter.notifyDataSetChanged()
        initViews()
        // Inflate the layout for this fragment
        return binding.root
    }

    private fun initViews() {
        val name = "Niels"
        val date = SimpleDateFormat("d MMM", Locale.getDefault()).format(Date())
        binding.tvGreeting.text = getString(R.string.greeting, name)
        binding.tvDate.text = getString(R.string.date,  date)
        binding.rvTopicsFollowing.layoutManager = StaggeredGridLayoutManager(1, RecyclerView.HORIZONTAL)
        binding.rvTopicsFollowing.adapter = topicAdapter
//        createItemTouchHelper().attachToRecyclerView(binding.rvQuestions)
    }

}