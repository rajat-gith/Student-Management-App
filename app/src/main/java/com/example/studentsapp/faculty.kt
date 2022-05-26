package com.example.studentsapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
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
        view.top_bar1.setOnClickListener {
            findNavController().navigate(R.id.action_faculty_to_home2)
        }
        val action=facultyDirections.actionFacultyToDeptpageForStudent(view.b1.text.toString())
        view.CHE.setOnClickListener {
            val action=facultyDirections.actionFacultyToDeptpageForStudent(view.b1.text.toString())
            Navigation.findNavController(view).navigate(action)
        }
        view.CE.setOnClickListener {
            val action=facultyDirections.actionFacultyToDeptpageForStudent(view.b2.text.toString())
            Navigation.findNavController(view).navigate(action)
        }
        view.CSE.setOnClickListener {
            val action=facultyDirections.actionFacultyToDeptpageForStudent(view.b3.text.toString())
            Navigation.findNavController(view).navigate(action)
        }
        view.EE.setOnClickListener {
            val action=facultyDirections.actionFacultyToDeptpageForStudent(view.b4.text.toString())
            Navigation.findNavController(view).navigate(action)
        }
        view.EEE.setOnClickListener {
            val action=facultyDirections.actionFacultyToDeptpageForStudent(view.b5.text.toString())
            Navigation.findNavController(view).navigate(action)
        }
        view.ETC.setOnClickListener {
            val action=facultyDirections.actionFacultyToDeptpageForStudent(view.b6.text.toString())
            Navigation.findNavController(view).navigate(action)
        }
        view.IT.setOnClickListener {
            val action=facultyDirections.actionFacultyToDeptpageForStudent(view.b7.text.toString())
            Navigation.findNavController(view).navigate(action)
        }
        view.ME.setOnClickListener {
            val action=facultyDirections.actionFacultyToDeptpageForStudent(view.b8.text.toString())
            Navigation.findNavController(view).navigate(action)
        }
        view.MME.setOnClickListener {
            val action=facultyDirections.actionFacultyToDeptpageForStudent(view.b9.text.toString())
            Navigation.findNavController(view).navigate(action)
        }
        view.PE.setOnClickListener {
            val action=facultyDirections.actionFacultyToDeptpageForStudent(view.b10.text.toString())
            Navigation.findNavController(view).navigate(action)
        }
        return view
    }

}