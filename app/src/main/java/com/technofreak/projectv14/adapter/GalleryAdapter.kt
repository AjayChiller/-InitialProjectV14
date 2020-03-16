package com.technofreak.projectv14.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.technofreak.projectv14.R
import com.technofreak.projectv14.model.GalleryPicture
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.listitem.view.*

class GalleryAdapter(private val list: List<GalleryPicture>) : RecyclerView.Adapter<GVH>() {

     private lateinit var onClick: (GalleryPicture) -> Unit


    fun setOnClickListener(onClick: (GalleryPicture) -> Unit) {
        this.onClick = onClick
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): GVH {


        val vh = GVH(LayoutInflater.from(p0.context).inflate(R.layout.listitem, p0, false))


        vh.containerView.setOnClickListener {
            val position = vh.adapterPosition
            val picture = getItem(position)
             onClick(picture)
       }
        return vh
    }


    private fun getItem(position: Int) = list[position]
    override fun onBindViewHolder(p0: GVH, p1: Int) {
        val picture = list[p1]
        Glide.with(p0.containerView).load(picture.path).into(p0.ivImg)
    }

    override fun getItemCount() = list.size
}


class GVH(    override val containerView: View)    : RecyclerView.ViewHolder(containerView),
    LayoutContainer {
    val ivImg: ImageView =containerView.ivImg
}