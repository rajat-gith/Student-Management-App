package com.example.studentsapp

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_admin_login_fragment.view.*


class admin_login_fragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view= inflater.inflate(R.layout.fragment_admin_login_fragment, container, false)
        view.admin_button2.setOnClickListener {
            var username=view.username.text.toString().trim()
            var password=view.password.text.toString().trim()
            var code=view.code.text.toString().trim()
            if(username=="admin_app@gmail.com"
                && password=="admin"
                && code=="1234"){
                findNavController().navigate(R.id.action_admin_login_fragment_to_admin_panel)
            }
            else{
                Toast.makeText(activity?.applicationContext,"Invalid Access", Toast.LENGTH_SHORT).show()
            }
        }
        return view
    }

}