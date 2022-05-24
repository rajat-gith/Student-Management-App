package com.example.studentsapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.fragment_deptpage_for_student.view.*


class deptpage_for_student : Fragment() {

    private lateinit var dbref:DatabaseReference
    private lateinit var faculty_recyclerview:RecyclerView
    private lateinit var facultylist:ArrayList<department_card>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view= inflater.inflate(R.layout.fragment_deptpage_for_student, container, false)
        faculty_recyclerview=view.faculty_recyclerview
        faculty_recyclerview.layoutManager=LinearLayoutManager(this.context)
        facultylist= arrayListOf<department_card>()
        getfacultydata()
        return view
    }

    private fun getfacultydata() {
        dbref=FirebaseDatabase.getInstance().getReference("Faculties")
        dbref.addValueEventListener(object:ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()){
                    for (userSnapshot in snapshot.children){
                        val user = userSnapshot.getValue(department_card::class.java)
                        facultylist.add(user!!)
                    }
                    faculty_recyclerview.adapter = Faculty_Adapter(facultylist)
                }
            }
            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })

    }

}