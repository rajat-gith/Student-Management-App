package com.example.studentsapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.navArgs
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.fragment_department_descriptiom.*
import kotlinx.android.synthetic.main.fragment_department_descriptiom.view.*


class Department_descriptiom : Fragment() {
    val args:Department_descriptiomArgs by navArgs()
    private lateinit var database:DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val branchname=args.departmentName
        val view=inflater.inflate(R.layout.fragment_department_descriptiom, container, false)
        val f_name=view.faculty_name
        val f_desgn=view.faculty_desgn
        val save=view.save
        save.setOnClickListener {
            val faculty_name=f_name.text.toString()
            val faculty_desgn=f_desgn.text.toString()
            database=FirebaseDatabase.getInstance().getReference("Faculties of $branchname")
            val faculty=department_card(faculty_name,faculty_desgn)
            database.child(faculty_name).setValue(faculty).addOnSuccessListener {
                Toast.makeText(activity?.applicationContext,"Successfully Saved", Toast.LENGTH_SHORT).show()
            }
        }
        return view
    }

}