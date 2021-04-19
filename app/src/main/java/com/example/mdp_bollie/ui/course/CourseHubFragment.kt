package com.example.mdp_bollie.ui.course

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import androidx.fragment.app.setFragmentResultListener
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mdp_bollie.R
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
        addStartCourse()
    }
    private fun initViews() {
        binding.rvCourses.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        binding.rvCourses.adapter = courseAdapter

        //onclicklisteners voor coursehub buttons
        binding.btnBezig.setOnClickListener(){
            removeCourse()
            bezigCourse()
        }
        binding.btnLater.setOnClickListener(){
            removeCourse()
            laterCourse()
        }
        binding.btnPdf.setOnClickListener(){
            removeCourse()
            pdfCourse()
        }
        binding.btnGesc.setOnClickListener(){
            removeCourse()
            gescCourse()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun removeCourse(){
        courses.clear()
        courseAdapter.notifyDataSetChanged()
    }

    private fun bezigCourse(){
        courseAdapter.notifyDataSetChanged()
        addCourse("koe melken", "jaap de boer")
    }

    private fun laterCourse(){
        courseAdapter.notifyDataSetChanged()
    }

    private fun pdfCourse(){
        courseAdapter.notifyDataSetChanged()
    }

    private fun gescCourse(){
        courseAdapter.notifyDataSetChanged()
    }

    private fun addCourse(courseName: String, courseAuther: String){
        courses.add(Course(courseName, courseAuther))
        courseAdapter.notifyDataSetChanged()
    }

    private fun addStartCourse(){
        val courseName: String = "Wiskunde"
        val courseAuther: String = "Jan"
        val courseName1: String = "Engels"
        val courseAuther1: String = "Piet"
        val courseName2: String = "Nederlands"
        val courseAuther2: String = "Gerard"

        courses.add(Course(courseName, courseAuther))
        courses.add(Course(courseName1, courseAuther1))
        courses.add(Course(courseName2, courseAuther2))
        courseAdapter.notifyDataSetChanged()

    }


}