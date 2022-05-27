package com.example.studentsapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TT_Adapter(private val tt_list:ArrayList<Time_Table_card>,private val click:TT_Adapter.OnItemClickListener):RecyclerView.Adapter<TT_Adapter.viewHolder>() {
    class viewHolder(itemView:View):RecyclerView.ViewHolder(itemView) {
        val tt_title=itemView.findViewById<TextView>(R.id.T_title)
        val dwnld_btn=itemView.findViewById<ImageView>(R.id.d_icon)
    }

    interface OnItemClickListener{
        fun onItemClick(item:String)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        val itemView= LayoutInflater.from(parent.context).inflate(R.layout.time_table,
            parent,false)
        return viewHolder(itemView)
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        val currentItem=tt_list[position]
        holder.tt_title.text=currentItem.time_table_title
        holder.dwnld_btn.setOnClickListener {
            click.onItemClick(tt_list.get(position).imgUrl!!)
        }
    }

    override fun getItemCount(): Int {
        return  tt_list.size
    }
}