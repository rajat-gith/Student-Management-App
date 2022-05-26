package com.example.studentsapp

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.google.android.gms.tasks.OnSuccessListener
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import com.google.firebase.storage.ktx.storage
import kotlinx.android.synthetic.main.fragment_create_notice.*
import kotlinx.android.synthetic.main.fragment_create_notice.view.*

private const val REQUEST_CODE_IMAGE_PICK = 0

class create_notice : Fragment() {
    lateinit var storage : StorageReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view= inflater.inflate(R.layout.fragment_create_notice, container, false)
        val upload_button=view.button2
        storage=FirebaseStorage.getInstance().reference.child("Notices")
        upload_button.setOnClickListener {
            Intent(Intent.ACTION_GET_CONTENT).also {
                it.type="application/pdf"
                startActivityForResult(it, REQUEST_CODE_IMAGE_PICK)
            }
        }
        return view
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(resultCode == Activity.RESULT_OK && requestCode == REQUEST_CODE_IMAGE_PICK) {
            val noticedata=data!!.data!!
            val notice_name=notice_name.text.toString()
            val noticename: StorageReference =storage.child("notice"+noticedata!!.lastPathSegment)
            noticename.putFile(noticedata).addOnSuccessListener(OnSuccessListener {
                noticename.downloadUrl.addOnSuccessListener(OnSuccessListener { uri->
                    val databaseReference:DatabaseReference=FirebaseDatabase.getInstance().getReference("Notices")
                    val url=uri.toString()
                    val notice=Notice_card("$notice_name","$url")
                    databaseReference.child("$notice_name").setValue(notice).addOnSuccessListener {
                        Toast.makeText(activity?.applicationContext,"Uploaded to Realtime DB",Toast.LENGTH_SHORT).show()
                    }
                })
            })

            }
        }
    }


