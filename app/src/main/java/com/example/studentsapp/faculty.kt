package com.example.studentsapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_faculty.view.*


class faculty : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view= inflater.inflate(R.layout.fragment_faculty, container, false)
        view.CHE.setOnClickListener {
            findNavController().navigate(R.id.action_faculty_to_deptpage_for_student)
        }
        view.CE.setOnClickListener {
            findNavController().navigate(R.id.action_faculty_to_deptpage_for_student)
        }
        view.CSE.setOnClickListener {
            findNavController().navigate(R.id.action_faculty_to_deptpage_for_student)
        }
        view.EE.setOnClickListener {
            findNavController().navigate(R.id.action_faculty_to_deptpage_for_student)
        }
        view.EEE.setOnClickListener {
            findNavController().navigate(R.id.action_faculty_to_deptpage_for_student)
        }
        view.ETC.setOnClickListener {
            findNavController().navigate(R.id.action_faculty_to_deptpage_for_student)
        }
        view.IT.setOnClickListener {
            findNavController().navigate(R.id.action_faculty_to_deptpage_for_student)
        }
        view.ME.setOnClickListener {
            findNavController().navigate(R.id.action_faculty_to_deptpage_for_student)
        }
        view.MME.setOnClickListener {
            findNavController().navigate(R.id.action_faculty_to_deptpage_for_student)
        }
        view.PE.setOnClickListener {
            findNavController().navigate(R.id.action_faculty_to_deptpage_for_student)
        }
        return view
    }

}