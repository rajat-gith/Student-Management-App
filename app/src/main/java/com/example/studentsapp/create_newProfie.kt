package com.example.studentsapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_sign_up.*
import kotlinx.android.synthetic.main.activity_signin.*
import kotlinx.android.synthetic.main.fragment_create_new_profie.*
import kotlinx.android.synthetic.main.fragment_create_new_profie.Name
import kotlinx.android.synthetic.main.fragment_create_new_profie.Phone
import kotlinx.android.synthetic.main.fragment_create_new_profie.view.*


class create_newProfie : Fragment() {
    private lateinit var db: FirebaseFirestore
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view= inflater.inflate(R.layout.fragment_create_new_profie, container, false)

        view.Submit.setOnClickListener {
            val action=create_newProfieDirections.actionCreateNewProfieToProfile()
            action.emailtoken=Registrationno.text.toString()
            db= FirebaseFirestore.getInstance()
            if(checking()){
                var name=Name.text.toString()
                var phone=Phone.text.toString()
                var semester=registerSemester.text.toString()
                var branch=registerBranch.text.toString()
                var address=registerAddress.text.toString()
                val regno=Registrationno.text.toString()

                val student= hashMapOf(
                    "Name" to name,
                    "Phone" to phone,
                    "Semester" to semester,
                    "Branch" to branch,
                    "Address" to address,
                    "Registration No" to regno
                )
                val students=db.collection("STUDENTS")
                students.document(regno).set(student)
                    .addOnSuccessListener {
                        Toast.makeText(activity?.applicationContext,"Uploaded",Toast.LENGTH_SHORT).show()
                    }
                }
            Navigation.findNavController(view).navigate(action)
        }
        return view
    }
    private fun checking():Boolean{
        if(Name.text.toString().trim{it<=' '}.isNotEmpty()
            && Phone.text.toString().trim{it<=' '}.isNotEmpty()
            && registerBranch.text.toString().trim{it<=' '}.isNotEmpty()
            && registerAddress.text.toString().trim{it<=' '}.isNotEmpty()
            && registerSemester.text.toString().trim{it<=' '}.isNotEmpty()
            && Registrationno.text.toString().trim{it<=' '}.isNotEmpty()){
            return true
        }
        return false
    }
}