package com.example.mdp_bollie.ui.home

import android.icu.util.Calendar
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation.findNavController
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.mdp_bollie.BottomNavActivity
import com.example.mdp_bollie.MainActivity
import com.example.mdp_bollie.R
import com.example.mdp_bollie.data.model.Course
import com.example.mdp_bollie.databinding.FragmentHomeBinding
import com.example.mdp_bollie.ui.CoursesViewModel
import java.text.SimpleDateFormat
import java.util.*


class HomeFragment : Fragment() {
    private lateinit var viewModel: CoursesViewModel
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val courses = arrayListOf<Course>()
    private val courseAdapter = CourseAdapter(courses)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.fetchCourses()

        viewModel.courses.observe(viewLifecycleOwner, Observer { newCourses ->
            courses.addAll(newCourses!)

        }

        )
        courseAdapter.notifyDataSetChanged()
        arguments?.let {
        }

    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this).get(CoursesViewModel::class.java)
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val navController = findNavController(requireActivity(), R.id.nav_host_fragment)

        binding.stimulationBtn.setOnClickListener{
           navController.navigate(R.id.action_navigation_home_to_navigation_course)

        }
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
        binding.rvTopicsFollowing.adapter = courseAdapter
//        createItemTouchHelper().attachToRecyclerView(binding.rvQuestions)
    }

}