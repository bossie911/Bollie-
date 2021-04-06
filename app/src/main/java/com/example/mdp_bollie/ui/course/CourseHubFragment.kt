package com.example.mdp_bollie.ui.course

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mdp_bollie.databinding.FragmentCourseHubBinding

class CourseHubFragment : Fragment() {
    private var _binding: FragmentCourseHubBinding? = null
    private val binding get() = _binding!!

    private val courses = arrayListOf<Course>()
    private val courseAdapter = CourseAdaptor(courses)

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCourseHubBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews()
    }
    private fun initViews() {
       // binding.rvCourses.layoutManager = LinearLayoutManager(RecyclerView.VERTICAL, false)
        binding.rvCourses.adapter = courseAdapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}