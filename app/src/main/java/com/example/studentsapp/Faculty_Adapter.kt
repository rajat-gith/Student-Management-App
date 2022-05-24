package com.example.studentsapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class Faculty_Adapter(private val facultylist:ArrayList<department_card>):RecyclerView.Adapter<Faculty_Adapter.faculty_viewholder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): faculty_viewholder {
        val itemView=LayoutInflater.from(parent.context).inf
    }

    override fun onBindViewHolder(holder: faculty_viewholder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        facultylist.size
    }


    class faculty_viewholder(itemView:View):RecyclerView.ViewHolder(itemView){


    }
}

