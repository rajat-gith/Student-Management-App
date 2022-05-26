package com.example.studentsapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
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
        view.ENIGMA.setOnClickListener {
            val action=non_academicDirections.actionNonAcademicToNonTechDesc(E_t.text.toString())
            Navigation.findNavController(view).navigate(action)
        }
        view.IIC.setOnClickListener {
            val action=non_academicDirections.actionNonAcademicToNonTechDesc(iic_t.text.toString())
            Navigation.findNavController(view).navigate(action)
        }
        view.vc.setOnClickListener {
            val action=non_academicDirections.actionNonAcademicToNonTechDesc(vc_t.text.toString())
            Navigation.findNavController(view).navigate(action)
        }
        view.dance.setOnClickListener {
            val action=non_academicDirections.actionNonAcademicToNonTechDesc(vib_t.text.toString())
            Navigation.findNavController(view).navigate(action)
        }
        view.souls.setOnClickListener {
            val action=non_academicDirections.actionNonAcademicToNonTechDesc(sou_t.text.toString())
            Navigation.findNavController(view).navigate(action)
        }
        view.sports.setOnClickListener {
            val action=non_academicDirections.actionNonAcademicToNonTechDesc(spo_t.text.toString())
            Navigation.findNavController(view).navigate(action)
        }
        view.samavesh.setOnClickListener {
            val action=non_academicDirections.actionNonAcademicToNonTechDesc(sam_t.text.toString())
            Navigation.findNavController(view).navigate(action)
        }

        return view
    }

}