package com.example.studentsapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.checkSelfPermission
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_home.view.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.jar.Manifest


class home : Fragment() {

    private lateinit var dbref:DatabaseReference
    private lateinit var notice_recyclerview:RecyclerView
    private lateinit var noticelist:ArrayList<Notice_card>
    var dataurl:String=""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view= inflater.inflate(R.layout.fragment_home, container, false)

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
                    notice_recyclerview.adapter = Notice_Adapter(noticelist)
                }
            }
            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })

    }

}