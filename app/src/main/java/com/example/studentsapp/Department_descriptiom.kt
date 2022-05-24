package com.example.studentsapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.fragment_department_descriptiom.*


class Department_descriptiom : Fragment() {
    private lateinit var database:DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val faculty_name=faculty_name.text.toString()
        val faculty_desgn=faculty_desgn.text.toString()
        val view=inflater.inflate(R.layout.fragment_department_descriptiom, container, false)
        database=FirebaseDatabase.getInstance().getReference("Faculties")
        val faculty=department_card(faculty_name,faculty_desgn)
        database.child(faculty_name).setValue(faculty).addOnSuccessListener {
            Toast.makeText(activity?.applicationContext,"Successfully Saved", Toast.LENGTH_SHORT).show()
        }


        return view
    }

}