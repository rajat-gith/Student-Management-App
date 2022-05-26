package com.example.studentsapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.ValueEventListener
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage


class Notice_Adapter(private val noticelist:ArrayList<Notice_card>, private val click:OnItemClickListener):RecyclerView.Adapter<Notice_Adapter.ViewHolder>() {

    val fileref=Firebase.storage.reference

    interface OnItemClickListener{
        fun onItemClick(item:String)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView=LayoutInflater.from(parent.context).inflate(R.layout.notice_card,
        parent,false)
        return ViewHolder(itemView)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentitem=noticelist[position]
        holder.notice_title.text=currentitem.noticetitle
        holder.dwnld_btn.setOnClickListener {
            click.onItemClick(noticelist.get(position).imgUrl!!)
        }
    }

    override fun getItemCount(): Int {
        return noticelist.size
    }
    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){

        val notice_title=itemView.findViewById<TextView>(R.id.Notice_title)
        val dwnld_btn=itemView.findViewById<ImageButton >(R.id.dwnldButton)
    }

}
