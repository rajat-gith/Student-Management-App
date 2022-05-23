package com.example.studentsapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_admin_login.*

class adminLogin : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin_login)
        admin_button2.setOnClickListener {
            var username=username.text.toString().trim()
            var password=password.text.toString().trim()
            var code=code.text.toString().trim()
            if(username=="admin_app@gmail.com"
                && password=="adminenter"
                && code=="1234"){
                val intent= Intent(this,admin_dashboard::class.java)
                startActivity(intent)
            }
            else{
                Toast.makeText(this,"Invalid Access",Toast.LENGTH_SHORT).show()
            }
        }

    }
}