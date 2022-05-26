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
import kotlinx.android.synthetic.main.fragment_non_tech_admin_domain.*


class non_tech_admin_domain : Fragment() {
    val args:non_tech_admin_domainArgs by navArgs()
    private lateinit var database:DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view= inflater.inflate(R.layout.fragment_non_tech_admin_domain, container, false)
        val admin_domain=args.domainAdminName
        upload.setOnClickListener {
            val domain_desc=admin_domain_desc.text.toString()
            database=FirebaseDatabase.getInstance().getReference("$admin_domain domain")
            val domain=domain_data_admin(domain_desc)
            database.child("$admin_domain").setValue(domain).addOnSuccessListener {
                Toast.makeText(activity?.applicationContext,"Data Successfully Uploaded",Toast.LENGTH_SHORT).show()
            }
        }
        return view
    }

}