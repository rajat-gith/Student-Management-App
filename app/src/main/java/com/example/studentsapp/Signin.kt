package com.example.studentsapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_signin.*

class Signin : AppCompatActivity() {
    private lateinit var auth:FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin)
        auth= FirebaseAuth.getInstance()
        signup.setOnClickListener {
            var intent =Intent(this,SignUp::class.java)
            startActivity(intent)
            finish()
        }
        signin.setOnClickListener {
            if(checking()){
                val email=email.text.toString()
                val password= password.text.toString()
                auth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this) { task ->
                        if (task.isSuccessful) {
                            var intent =Intent(this,MainActivity::class.java)
                            intent.putExtra("email",email)
                            startActivity(intent)
                            finish()
                        } else {
                            Toast.makeText(this, "Wrong Details", Toast.LENGTH_LONG).show()
                        }
                    }
            }
            else{
                Toast.makeText(this,"Enter the Details",Toast.LENGTH_LONG).show()
            }
        }
        admin_button.setOnClickListener {
            val intent=Intent(this,adminLogin::class.java)
            startActivity(intent)
        }
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