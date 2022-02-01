package com.example.retrofit1.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofit1.Model.MChannel
import com.example.retrofit1.R
import com.squareup.picasso.Picasso

class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val imageView: ImageView = itemView.findViewById(R.id.imageChannel)
    val idTextView: TextView = itemView.findViewById(R.id.idView)
    val titleTextView: TextView = itemView.findViewById(R.id.titleView)
    val aliasTextView: TextView = itemView.findViewById(R.id.aliasView)

    fun bind(listItem: MChannel) {
        imageView.setOnClickListener {
            Toast.makeText(it.context, "нажал на картинку канала", Toast.LENGTH_SHORT)
                .show()
        }
        itemView.setOnClickListener {
            Toast.makeText(it.context, "нажал на текст", Toast.LENGTH_SHORT).show()
        }
    }
}

class MyChannelAdapter(
    private val context: Context,
    private val channelsList: MutableList<MChannel>
) : RecyclerView.Adapter<MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val listItem = channelsList[position]
        holder.bind(listItem)

        Picasso.get().load(channelsList[position].logoURL).into(holder.imageView)
        holder.idTextView.text = channelsList[position].channelId.toString()
        holder.titleTextView.text = channelsList[position].title
        holder.aliasTextView.text = channelsList[position].alias
    }

    override fun getItemCount() = channelsList.size
}