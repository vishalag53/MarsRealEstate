package com.vishalag53.marsrealestate.overview


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.vishalag53.marsrealestate.databinding.GridViewItemBinding
import com.vishalag53.marsrealestate.network.MarsProperty

class PhotoGridAdapters : ListAdapter<MarsProperty, PhotoGridAdapters.MarsPropertyViewolder>(DiffCallback){
    class MarsPropertyViewolder(private var binding: GridViewItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(marsProperty: MarsProperty){
            binding.property = marsProperty
            binding.executePendingBindings()
        }
    }

    companion object DiffCallback: DiffUtil.ItemCallback<MarsProperty>(){
        override fun areItemsTheSame(oldItem: MarsProperty, newItem: MarsProperty): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: MarsProperty, newItem: MarsProperty): Boolean {
            return oldItem.id == newItem.id
        }

    }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): PhotoGridAdapters.MarsPropertyViewolder {
        return MarsPropertyViewolder(GridViewItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: PhotoGridAdapters.MarsPropertyViewolder, position: Int) {
        val marsProperty = getItem(position)
        holder.bind(marsProperty)
    }

}