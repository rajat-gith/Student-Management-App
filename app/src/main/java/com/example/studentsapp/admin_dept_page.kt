package com.example.studentsapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_admin_dept_page.view.*

class admin_dept_page : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view= inflater.inflate(R.layout.fragment_admin_dept_page, container, false)

        view.CHE.setOnClickListener {
            val action=admin_dept_pageDirections.actionAdminDeptPageToDepartmentDescriptiom(view.b1.text.toString())
            Navigation.findNavController(view).navigate(action)
        }
        view.CE.setOnClickListener {
            val action=admin_dept_pageDirections.actionAdminDeptPageToDepartmentDescriptiom(view.b2.text.toString())
            Navigation.findNavController(view).navigate(action)
        }
        view.CSE.setOnClickListener {
            val action=admin_dept_pageDirections.actionAdminDeptPageToDepartmentDescriptiom(view.b3.text.toString())
            Navigation.findNavController(view).navigate(action)
        }
        view.EE.setOnClickListener {
            val action=admin_dept_pageDirections.actionAdminDeptPageToDepartmentDescriptiom(view.b4.text.toString())
            Navigation.findNavController(view).navigate(action)
        }
        view.EEE.setOnClickListener {
            val action=admin_dept_pageDirections.actionAdminDeptPageToDepartmentDescriptiom(view.b5.text.toString())
            Navigation.findNavController(view).navigate(action)
        }
        view.ETC.setOnClickListener {
            val action=admin_dept_pageDirections.actionAdminDeptPageToDepartmentDescriptiom(view.b6.text.toString())
            Navigation.findNavController(view).navigate(action)
        }
        view.IT.setOnClickListener {
            val action=admin_dept_pageDirections.actionAdminDeptPageToDepartmentDescriptiom(view.b7.text.toString())
            Navigation.findNavController(view).navigate(action)
        }
        view.ME.setOnClickListener {
            val action=admin_dept_pageDirections.actionAdminDeptPageToDepartmentDescriptiom(view.b8.text.toString())
            Navigation.findNavController(view).navigate(action)
        }
        view.MME.setOnClickListener {
            val action=admin_dept_pageDirections.actionAdminDeptPageToDepartmentDescriptiom(view.b9.text.toString())
            Navigation.findNavController(view).navigate(action)
        }
        view.PE.setOnClickListener {
            val action=admin_dept_pageDirections.actionAdminDeptPageToDepartmentDescriptiom(view.b10.text.toString())
            Navigation.findNavController(view).navigate(action)
        }

        return view
    }

}