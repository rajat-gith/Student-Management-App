package com.example.studentsapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.fragment_profile.view.*


class profile : Fragment() {
    private lateinit var db: FirebaseFirestore
    val args:profileArgs by navArgs()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val emailtoken=args.emailtoken
        val view= inflater.inflate(R.layout.fragment_profile, container, false)
        db= FirebaseFirestore.getInstance()
        val action=profileDirections.actionProfileToCreateNewProfie(emailtoken)
        view.Edit.setOnClickListener {
            Navigation.findNavController(view).navigate(action)
        }
        val docref = db.collection("USERS").document(emailtoken)
        if (docref != null) {
            docref.get()
                .addOnSuccessListener {
                    document->
                    if(document!=null){
                        view.Semester.text=document["Semester"].toString()
                        view.Branch.text=document["Branch"].toString()
                        view.Phoneno.text=document["Phone"].toString()
                        view.address.text=document["Address"].toString()
                        view.Name.text=document["Name"].toString()
                        view.regno.text=document["Reg_no"].toString()
                    }
                }
        }
        return view
    }

}