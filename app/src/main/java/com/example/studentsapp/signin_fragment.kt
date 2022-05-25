package com.example.studentsapp

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.fragment_signin_fragment.*
import kotlinx.android.synthetic.main.fragment_signin_fragment.view.*


class signin_fragment : Fragment() {
    private lateinit var auth:FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view=inflater.inflate(R.layout.fragment_signin_fragment, container, false)
        auth= FirebaseAuth.getInstance()
        view.signup.setOnClickListener {
            findNavController().navigate(R.id.action_signin_fragment_to_signup_fragment)
        }
        view.signin.setOnClickListener {
            if(checking()){
                val email=view.email.text.toString()
                val password= view.password.text.toString()
                auth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(requireActivity()) { task ->
                        if (task.isSuccessful) {
                            findNavController().navigate(R.id.action_signin_fragment_to_home2)
                        } else {
                            Toast.makeText(activity?.applicationContext, "Wrong Details", Toast.LENGTH_LONG).show()
                        }
                    }
            }
            else{
                Toast.makeText(activity?.applicationContext,"Enter the Details", Toast.LENGTH_LONG).show()
            }
        }
        view.admin_button.setOnClickListener {
            findNavController().navigate(R.id.action_signin_fragment_to_admin_login_fragment)
        }
        return view
    }
    private fun checking():Boolean
    {
        if(email.text.toString().trim{it<=' '}.isNotEmpty()
            && password.text.toString().trim{it<=' '}.isNotEmpty()){
            return true
        }
        return false
    }
}