package com.example.studentsapp

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.google.android.gms.tasks.OnSuccessListener
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import kotlinx.android.synthetic.main.fragment_non_tech_admin_domain.view.*
import kotlinx.android.synthetic.main.fragment_splashscrren_fragment.*
import kotlinx.android.synthetic.main.fragment_timetable_fragment.*
import kotlinx.android.synthetic.main.fragment_timetable_fragment.view.*
import java.sql.Time

private const val REQUEST_CODE_IMAGE_PICK = 0


class timetable_fragment : Fragment() {
    lateinit var storage : StorageReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view= inflater.inflate(R.layout.fragment_timetable_fragment, container, false)
        storage=FirebaseStorage.getInstance().reference.child("TIME_TABLE")
        view.upload_doc.setOnClickListener {
            Intent(Intent.ACTION_GET_CONTENT).also {
                it.type="application/pdf"
                startActivityForResult(it, REQUEST_CODE_IMAGE_PICK)
            }

        }
        return view
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(resultCode==Activity.RESULT_OK && requestCode== REQUEST_CODE_IMAGE_PICK){
            val tt_data=data!!.data!!
            val tt_name=time_table_title.text.toString()
            val ttname:StorageReference=storage.child("Time_Table"+tt_data!!.lastPathSegment)
            ttname.putFile(tt_data).addOnSuccessListener(OnSuccessListener {
                ttname.downloadUrl.addOnSuccessListener(OnSuccessListener { uri->
                val databaseReference:DatabaseReference=FirebaseDatabase.getInstance().getReference("TIME_TABLE")
                val url=uri.toString()
                val time_table=Time_Table_card("$tt_name","$url")
                databaseReference.child(("$tt_name")).setValue(time_table).addOnSuccessListener {
                    Toast.makeText(activity?.applicationContext,"Fetched and Uploaded to Database",Toast.LENGTH_SHORT).show()
                }
                })
            })
        }
    }
}