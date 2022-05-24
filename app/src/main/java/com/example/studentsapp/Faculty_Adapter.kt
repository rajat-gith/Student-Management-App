package com.example.studentsapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Faculty_Adapter(private val facultylist:ArrayList<department_card>):RecyclerView.Adapter<Faculty_Adapter.faculty_viewholder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): faculty_viewholder {
        val itemView=LayoutInflater.from(parent.context).inflate(R.layout.faculty_card,parent,false)
        return faculty_viewholder(itemView)
    }

    override fun onBindViewHolder(holder: faculty_viewholder, position: Int) {
        val currentitem=facultylist[position]
        holder.f_name.text=currentitem.faculty_name
        holder.f_name.text=currentitem.faculty_desgn
    }

    override fun getItemCount(): Int {
        return facultylist.size
    }


    class faculty_viewholder(itemView:View):RecyclerView.ViewHolder(itemView){

        val f_name=itemView.findViewById<TextView>(R.id.f_name)
        val f_desgn=itemView.findViewById<TextView>(R.id.f_desgn)
    }
}

