package com.example.mdp_bollie.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.mdp_bollie.R


class HomeFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    private fun initViews() {
        binding.rvQuestions.layoutManager = StaggeredGridLayoutManager(1, RecyclerView.VERTICAL)
        binding.rvQuestions.adapter = questionAdapter
        createItemTouchHelper().attachToRecyclerView(binding.rvQuestions)
    }

}