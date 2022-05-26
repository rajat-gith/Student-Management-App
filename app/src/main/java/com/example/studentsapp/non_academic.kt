package com.example.studentsapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_non_academic.*
import kotlinx.android.synthetic.main.fragment_non_academic.view.*


class non_academic : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view= inflater.inflate(R.layout.fragment_non_academic, container, false)
        view.RS.setOnClickListener {
            val action=non_academicDirections.actionNonAcademicToNonTechDesc(Rs_t.text.toString())
            Navigation.findNavController(view).navigate(action)
        }
        view.enigma.setOnClickListener {
            val action=non_academicDirections.actionNonAcademicToNonTechDesc(E_t.text.toString())
            Navigation.findNavController(view).navigate(action)
        }
        view.iic1.setOnClickListener {
            val action=non_academicDirections.actionNonAcademicToNonTechDesc(iic_t1.text.toString())
            Navigation.findNavController(view).navigate(action)
        }
        view.vc1.setOnClickListener {
            val action=non_academicDirections.actionNonAcademicToNonTechDesc(vc_t.text.toString())
            Navigation.findNavController(view).navigate(action)
        }
        view.dance1.setOnClickListener {
            val action=non_academicDirections.actionNonAcademicToNonTechDesc(vib_t1.text.toString())
            Navigation.findNavController(view).navigate(action)
        }
        view.souls1.setOnClickListener {
            val action=non_academicDirections.actionNonAcademicToNonTechDesc(sou_t1.text.toString())
            Navigation.findNavController(view).navigate(action)
        }
        view.sports1.setOnClickListener {
            val action=non_academicDirections.actionNonAcademicToNonTechDesc(spo_t1.text.toString())
            Navigation.findNavController(view).navigate(action)
        }
        view.samavesh1.setOnClickListener {
            val action=non_academicDirections.actionNonAcademicToNonTechDesc(sam_t1.text.toString())
            Navigation.findNavController(view).navigate(action)
        }
        view.top_bar.setOnClickListener {
            findNavController().navigate(R.id.action_non_academic_to_home2)
        }
        return view
    }

}