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
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.fragment_signup_fragment.*
import kotlinx.android.synthetic.main.fragment_signup_fragment.view.*

class signup_fragment : Fragment() {
    private lateinit var auth: FirebaseAuth
    private lateinit var db: FirebaseFirestore
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view=inflater.inflate(R.layout.fragment_signup_fragment, container, false)
        auth= FirebaseAuth.getInstance()
        db= FirebaseFirestore.getInstance()
        view.button.setOnClickListener {
            if(checking())
            {
                var email=view.EmailRegister.text.toString()
                var password= view.PasswordRegister.text.toString()
                var name=view.Name.text.toString()
                var phone=view.Phone.text.toString()
                val user= hashMapOf(
                    "Name" to name,
                    "Phone" to phone,
                    "email" to email
                )
                val Users=db.collection("USERS")
                val query =Users.whereEqualTo("email",email).get()
                    .addOnSuccessListener {
                            tasks->
                        if(tasks.isEmpty)
                        {
                            auth.createUserWithEmailAndPassword(email,password)
                                .addOnCompleteListener(requireActivity()){
                                        task->
                                    if(task.isSuccessful)
                                    {
                                        Users.document(email).set(user)
                                        findNavController().navigate(R.id.action_signup_fragment_to_signin_fragment)
                                    }
                                    else
                                    {
                                        Toast.makeText(activity?.applicationContext,"Authentication Failed", Toast.LENGTH_LONG).show()
                                    }
                                }
                        }
                        else
                        {
                            Toast.makeText(activity?.applicationContext,"User Already Registered", Toast.LENGTH_LONG).show()
                            findNavController().navigate(R.id.action_signup_fragment_to_signin_fragment)
                        }
                    }
            }
            else{
                Toast.makeText(activity?.applicationContext,"Enter the Details", Toast.LENGTH_LONG).show()
            }
        }
        return view
    }
    private fun checking():Boolean{
        if(Name.text.toString().trim{it<=' '}.isNotEmpty()
            && Phone.text.toString().trim{it<=' '}.isNotEmpty()
            && EmailRegister.text.toString().trim{it<=' '}.isNotEmpty()
            && PasswordRegister.text.toString().trim{it<=' '}.isNotEmpty()
        )
        {
            return true
        }
        return false
    }
}