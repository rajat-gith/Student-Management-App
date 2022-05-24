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
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage
import kotlinx.android.synthetic.main.fragment_create_notice.*
import kotlinx.android.synthetic.main.fragment_create_notice.view.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext

private const val REQUEST_CODE_IMAGE_PICK = 0

class create_notice : Fragment() {
    var curFile: Uri? = null
    private lateinit var url:String
    val docref = Firebase.storage.reference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view= inflater.inflate(R.layout.fragment_create_notice, container, false)
        val upload_button=view.button2
        val fileicon=view.fileicon
        val title_field=view.notice_title



        fileicon.setOnClickListener {
            Intent(Intent.ACTION_GET_CONTENT).also {
                it.type="application/pdf"
                startActivityForResult(it, REQUEST_CODE_IMAGE_PICK)
            }
        }

        upload_button.setOnClickListener {
            val title=title_field.text.toString()
            uploadImageToStorage(title)
        }
        return view
    }

    private fun uploadImageToStorage(filename: String) = CoroutineScope(Dispatchers.IO).launch {
        try {
            curFile?.let {
                docref.child("Notices/$filename").putFile(it).await()

                withContext(Dispatchers.Main) {

                    Toast.makeText(activity?.applicationContext, "Successfully uploaded to Cloud",
                        Toast.LENGTH_LONG).show()
                }
            }
        } catch (e: Exception) {
            withContext(Dispatchers.Main) {
                Toast.makeText(activity?.applicationContext, e.message, Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(resultCode == Activity.RESULT_OK && requestCode == REQUEST_CODE_IMAGE_PICK) {
            data?.data?.let {
                curFile = it
                fileicon.setImageResource(R.drawable.ic_pdf_icon)
                textView.text=""
                Toast.makeText(activity?.applicationContext,"File Fetched",Toast.LENGTH_SHORT).show()
            }
        }
    }


}