package com.example.studentsapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Notice_Adapter(private val noticelist:ArrayList<Notice_card>):RecyclerView.Adapter<Notice_Adapter.ViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView=LayoutInflater.from(parent.context).inflate(R.layout.notice_card,
        parent,false)
        return ViewHolder(itemView)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentitem=noticelist[position]
        holder.notice_title.text=currentitem.noticetitle
    }

    override fun getItemCount(): Int {
        return noticelist.size
    }
    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){

        val notice_title=itemView.findViewById<TextView>(R.id.Notice_title)

    }
}