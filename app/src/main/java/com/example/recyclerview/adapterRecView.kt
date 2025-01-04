package com.example.recyclerview

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class adapterRecView(private val listWayang: ArrayList<wayang>) :
    RecyclerView.Adapter<adapterRecView.ListViewHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback

    interface OnItemClickCallback {
        fun onItemClicked(data: wayang)
        fun delData(pos: Int)
    }

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback

    }

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var _gambarWayang: ImageView = itemView.findViewById(R.id.gambarWayang)
        var _karakterWayang: TextView = itemView.findViewById(R.id.karakterWayang)
        var _deskripsiWayang: TextView = itemView.findViewById(R.id.deskripsiWayang)
        var _namaWayang: TextView = itemView.findViewById(R.id.namaWayang)
        var _btnHapus: Button = itemView.findViewById(R.id.btnHapus)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_recycler, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listWayang.size
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val wayang = listWayang[position]

        holder._namaWayang.text = wayang.nama
        holder._deskripsiWayang.text = wayang.deskripsi
        holder._karakterWayang.text = wayang.karakter
        Log.d("TEST", wayang.foto)

        Picasso.get().load(wayang.foto).into(holder._gambarWayang)

        holder._gambarWayang.setOnClickListener {
            onItemClickCallback.onItemClicked(wayang)
        }

        holder.itemView.setOnClickListener {
            onItemClickCallback.onItemClicked(wayang)
        }

        holder._btnHapus.setOnClickListener {
            onItemClickCallback.delData(position)
        }
    }
}
