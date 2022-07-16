package com.example.unsplash_penguinin.ui.adapter

import android.content.Context
import android.content.Intent
import android.media.Image
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
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

        init {
            photo = itemView.findViewById(R.id.photo)
            description = itemView.findViewById(R.id.description_tv)
            name = itemView.findViewById(R.id.name_tv)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotosViewHolder {
        val itemView: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_photos, parent, false)
        return PhotosViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: PhotosViewHolder, position: Int) {


        if (items[position].urls.small != null && items[position].urls.small != "") {
            Glide.with(context)
                .load(items[position].urls.small)
                .centerCrop()
                .into(holder.photo)

        } else if (items[position].urls.small == null || items[position].urls.small == "") {
            Glide.with(context)
                .load(context.getString(R.string.placeholder_link))
                .centerCrop()
                .into(holder.photo)
        }

        if (items[position].alt_description != null && items[position].alt_description != "")
            holder.description.text = items[position].alt_description
        else if (items[position].alt_description == null || items[position].alt_description == "")
            holder.description.text = "Description not Available!!"


        if (items[position].user.name != null && items[position].user.name != "") {
            holder.name.text = items[position].user.name
            if (items[position].user.portfolio_url != null && items[position].user.portfolio_url != "") {
                holder.name.setOnClickListener {
                    context.startActivity(
                        Intent(
                            Intent.ACTION_VIEW,
                            Uri.parse(items[position].user.portfolio_url)
                        )
                    )
                }
            } else if (items[position].user.portfolio_url == null || items[position].user.portfolio_url == "") {
                holder.name.setOnClickListener {
                    Toast.makeText(context, "Portfolio not Available!", Toast.LENGTH_SHORT).show()
                }
            }
        } else if (items[position].user.name == null || items[position].user.name == "")
            holder.name.text = "Name not Available!"
    }

    override fun getItemCount(): Int {
        return items.size
    }
}