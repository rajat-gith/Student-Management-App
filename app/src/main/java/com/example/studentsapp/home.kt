package com.example.studentsapp

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
import androidx.core.content.ContextCompat.*
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.fragment_home.view.*
import java.util.jar.Manifest
import android.hardware.SensorManager
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import kotlinx.android.synthetic.main.fragment_admin_panel.view.*


class home : Fragment(),Notice_Adapter.OnItemClickListener {
    val args:homeArgs by navArgs()
    private lateinit var dbref:DatabaseReference
    private lateinit var notice_recyclerview:RecyclerView
    private lateinit var noticelist:ArrayList<Notice_card>
    var dataurl:String=""
    var dataUri:ArrayList<Uri> = ArrayList()
    private val REQ_CODE=100
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view= inflater.inflate(R.layout.fragment_home, container, false)
        val action=homeDirections.actionHome2ToProfile(args.emailaddress.toString())
        notice_recyclerview=view.notice_recycler_view
        notice_recyclerview.layoutManager=LinearLayoutManager(this.context)
        noticelist= arrayListOf<Notice_card>()
        getnoticedata()


        view.academic_button.setOnClickListener {
            findNavController().navigate(R.id.action_home2_to_academic)
        }
        view.non_academic_button.setOnClickListener {
            findNavController().navigate(R.id.action_home2_to_non_academic)
        }
        view.top_bar.setOnClickListener {
            Navigation.findNavController(view).navigate(action)
        }
        return view

    }
    private fun getnoticedata() {
        dbref = FirebaseDatabase.getInstance().getReference("Notices")

        dbref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()){
                    for (userSnapshot in snapshot.children){
                        val user = userSnapshot.getValue(Notice_card::class.java)
                        noticelist.add(user!!)
                    }

                    notice_recyclerview.adapter = Notice_Adapter(noticelist,this@home)
                }
            }
            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })

    }
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onItemClick(item: String) {
        dataurl=item
        if(context?.let { checkSelfPermission(it,android.Manifest.permission.WRITE_EXTERNAL_STORAGE) } ==PackageManager.PERMISSION_DENIED){
            requestPermissions(arrayOf(android.Manifest.permission.WRITE_EXTERNAL_STORAGE),REQ_CODE)
        }else{
            startDownloading()
        }
            Toast.makeText(activity?.applicationContext,"You Clicked on Download Button",Toast.LENGTH_SHORT).show()
    }
    private fun startDownloading(){
        val request=DownloadManager.Request(Uri.parse(dataurl))
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
}