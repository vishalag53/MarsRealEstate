package com.vishalag53.marsrealestate

import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.vishalag53.marsrealestate.network.MarsProperty
import com.vishalag53.marsrealestate.overview.PhotoGridAdapters

@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView,data: List<MarsProperty>?){
    val adapter = recyclerView.adapter as PhotoGridAdapters
    adapter.submitList(data)
}


@BindingAdapter("imageUrl")
fun bindImage(imgView: ImageView, imgUrl: String?){
    imgUrl?.let{
        val imgUri = imgUrl.toUri().buildUpon().scheme("https").build()
        Glide.with(imgView.context)
            .load(imgUri)
            .apply(RequestOptions()
                .placeholder(R.drawable.loading_animation)
                .error(R.drawable.ic_broken_image))
            .into(imgView)
    }
}