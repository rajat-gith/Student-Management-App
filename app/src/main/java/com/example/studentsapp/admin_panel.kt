package com.example.studentsapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_admin_panel.*
import kotlinx.android.synthetic.main.fragment_admin_panel.view.*

class admin_panel : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view= inflater.inflate(R.layout.fragment_admin_panel, container, false)

        val dept=view.department
        val notice_card=view.notice_card
        dept.setOnClickListener {
            findNavController().navigate(R.id.action_admin_panel_to_department_descriptiom)
        }
        notice_card.setOnClickListener {
            findNavController().navigate(R.id.action_admin_panel_to_create_notice)
        }
        return view
    }


}