package com.example.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class adapterRecView (private val listWayang: ArrayList<wayang>) :
    RecyclerView.Adapter<adapterRecView.ListViewHolder>() {
    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var _gambarWayang: ImageView = itemView.findViewById(R.id.gambarWayang)
        var _karakterWayang: TextView = itemView.findViewById(R.id.karakterWayang)
        var _deskripsiWayang: TextView = itemView.findViewById(R.id.deskripsiWayang)
        var _namaWayang: TextView = itemView.findViewById(R.id.namaWayang)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_recycler, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listWayang.size
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        var wayang = listWayang[position]
        holder._namaWayang.setText(wayang.nama)
        holder._deskripsiWayang.setText(wayang.deskripsi)
        holder._karakterWayang.setText(wayang.karakter)
    }

}
