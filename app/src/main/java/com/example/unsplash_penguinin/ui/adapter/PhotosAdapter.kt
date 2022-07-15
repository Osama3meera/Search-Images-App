package com.example.unsplash_penguinin.ui.adapter

import android.content.Context
import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.unsplash_penguinin.R
import com.example.unsplash_penguinin.model.Results

class PhotosAdapter(var context: Context, var items: ArrayList<Results>) :
    RecyclerView.Adapter<PhotosAdapter.PhotosViewHolder>() {


    inner class PhotosViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var photo: ImageView
        var description: TextView
        var name: TextView
        var link: TextView

        init {
            photo = itemView.findViewById(R.id.photo)
            description = itemView.findViewById(R.id.description_tv)
            name = itemView.findViewById(R.id.name_tv)
            link = itemView.findViewById(R.id.link_tv)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotosViewHolder {
        val itemView: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_photos, parent, false)
        return PhotosViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: PhotosViewHolder, position: Int) {

        Glide.with(context)
            .load(items[position].urls.thumb)
            .centerCrop()
            .into(holder.photo)

        holder.description.text = items[position].description
        holder.name.text = items[position].user.name
        holder.link.text = items[position].user.portfolio_url
    }

    override fun getItemCount(): Int {
        return items.size
    }
}