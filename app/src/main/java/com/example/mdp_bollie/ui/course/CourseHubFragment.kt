package com.example.mdp_bollie.ui.course

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mdp_bollie.R
import com.example.mdp_bollie.data.adapter.CourseAdapter
import com.example.mdp_bollie.data.model.Course
import com.example.mdp_bollie.databinding.FragmentCourseHubBinding
import com.example.mdp_bollie.ui.CoursesViewModel


class CourseHubFragment : Fragment() {
    private lateinit var viewModel: CoursesViewModel
    private var _binding: FragmentCourseHubBinding? = null
    private val binding get() = _binding!!

    private val courses = arrayListOf<Course>()

    private val courseAdapter = CourseAdapter(courses)




    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val navController = findNavController()
        courseAdapter.setNavController(navController)
        viewModel = ViewModelProvider(this).get(CoursesViewModel::class.java)
        loadCourses()
        _binding = FragmentCourseHubBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews()
        //addStartCourse()
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

    private fun loadCourses(){
        viewModel.fetchCourses()

        viewModel.courses.observe(viewLifecycleOwner, Observer { newCourses ->
            courses.addAll(newCourses)
            courseAdapter.notifyDataSetChanged()
        })
    }

    private fun addCourse(courseName: String, courseAuthor: String){
        courses.add(Course(courseName))
        courseAdapter.notifyDataSetChanged()
    }

    private fun addStartCourse(){
        val courseName: String = "Wiskunde"
        val courseAuther: String = "Jan"
        val courseName1: String = "Engels"
        val courseAuther1: String = "Piet"
        val courseName2: String = "Nederlands"
        val courseAuther2: String = "Gerard"

        courses.add(Course(courseName))
        courses.add(Course(courseName1))
        courses.add(Course(courseName2))
        courseAdapter.notifyDataSetChanged()

    }


}