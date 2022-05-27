package com.example.studentsapp

import android.Manifest
import android.app.DownloadManager
import android.content.Context
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.Environment
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.fragment_student_time_table.view.*


class student_time_table : Fragment(),TT_Adapter.OnItemClickListener {
    var dataurl:String=""
    private val REQ_CODE=100
    private lateinit var dbref: DatabaseReference
    private lateinit var ttlist:ArrayList<Time_Table_card>
    private lateinit var tt_recyclerview:RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view= inflater.inflate(R.layout.fragment_student_time_table, container, false)
        tt_recyclerview=view.recyclerView
        tt_recyclerview.layoutManager=LinearLayoutManager(this.context)
        ttlist= arrayListOf<Time_Table_card>()
        getTTdata()
        return view
    }
    private fun getTTdata(){
        dbref=FirebaseDatabase.getInstance().getReference("TIME_TABLE")
        dbref.addValueEventListener(object :ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                if(snapshot.exists()){
                    for(ttsnapshot in snapshot.children){
                        val tt=ttsnapshot.getValue(Time_Table_card::class.java)
                        ttlist.add(tt!!)
                    }
                    tt_recyclerview.adapter=TT_Adapter(ttlist,this@student_time_table)
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
    }



    @RequiresApi(Build.VERSION_CODES.M)

    private fun startDownloading(){
        val request= DownloadManager.Request(Uri.parse(dataurl))
        request.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_WIFI or DownloadManager.Request.NETWORK_MOBILE)
        request.setTitle("Download")
        request.setDescription("Your File is Downloading >>>")
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)
        request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS,"${System.currentTimeMillis()}")
        val Manager = activity!!.getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager
        Manager.enqueue(request)
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        when(requestCode){
            REQ_CODE->{
                if(grantResults.isNotEmpty() && grantResults[0]==PackageManager.PERMISSION_GRANTED){
                    startDownloading()
                }else{
                    Toast.makeText(activity?.applicationContext,"Permission not Granted",Toast.LENGTH_SHORT).show()
                }
            }
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }

    override fun onItemClick(item: String) {
        dataurl=item
        if(context?.let {
                ContextCompat.checkSelfPermission(
                    it,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE
                )
            } ==PackageManager.PERMISSION_DENIED){
            requestPermissions(arrayOf(android.Manifest.permission.WRITE_EXTERNAL_STORAGE),REQ_CODE)
        }else{
            startDownloading()
        }
        Toast.makeText(activity?.applicationContext,"You Clicked on Download Button",Toast.LENGTH_SHORT).show()
    }
}