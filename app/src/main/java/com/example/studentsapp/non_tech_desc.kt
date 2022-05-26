package com.example.studentsapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.google.firebase.database.*
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.fragment_non_tech_desc.*
import kotlinx.android.synthetic.main.fragment_non_tech_desc.view.*


class non_tech_desc : Fragment() {
    val args:non_tech_descArgs by navArgs()
    private lateinit var dbref: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view= inflater.inflate(R.layout.fragment_non_tech_desc, container, false)
        val admin_domain=args.domainName
        dbref = FirebaseDatabase.getInstance().getReference("$admin_domain domain")
        dbref.addValueEventListener(object :ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                if(snapshot.exists()){
                    val desc=snapshot.child("$admin_domain/domain_desc").getValue()
                    domain_desc.text=desc.toString()
                }

            }
            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })


        return view
    }

}