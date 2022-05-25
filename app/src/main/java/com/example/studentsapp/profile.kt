package com.example.studentsapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.fragment_profile.view.*


class profile : Fragment() {
    private lateinit var db: FirebaseFirestore
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view= inflater.inflate(R.layout.fragment_profile, container, false)
        db= FirebaseFirestore.getInstance()

        view.Edit.setOnClickListener {
            findNavController().navigate(R.id.action_profile_to_create_newProfie)
        }






        val docref = db.collection("USERS").document("rajatnayak1582002@gmail.com")
        if (docref != null) {
            docref.get()
                .addOnSuccessListener {
                    document->
                    if(document!=null){
                        view.Semester.text=document["Semester"].toString()
                        view.Branch.text=document["Branch"].toString()
                        view.Phoneno.text=document["Phone"].toString()
                        view.address.text=document["Address"].toString()
                        view.Email.text=document["email"].toString()

                    }
                }
        }
        return view
    }

}