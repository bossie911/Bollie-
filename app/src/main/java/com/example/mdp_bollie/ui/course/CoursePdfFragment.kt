package com.example.mdp_bollie.ui.course

import android.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.mdp_bollie.databinding.FragmentCoursePdfBinding
import com.github.barteksc.pdfviewer.PDFView


class CoursePdfFragment : Fragment() {
    private var _binding: FragmentCoursePdfBinding? = null
    private val binding get() = _binding!!



    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCoursePdfBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val pdfView = binding.pdfView
        pdfView.fromAsset("test.pdf").load()
    }




    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}