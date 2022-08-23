package com.example.recyclerviewdiffutils

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncDifferConfig
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewdiffutils.databinding.ItemRowBinding

class SampleAdapter : RecyclerView.Adapter<SampleAdapter.ViewHolder>() {

private lateinit var binding: ItemRowBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
    binding = ItemRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.setData(differ.currentList[position])
            holder.setIsRecyclable(false)
    }

    override fun getItemCount() = differ.currentList.size

    //differutils

    inner class ViewHolder : RecyclerView.ViewHolder(binding.root){
        fun setData(item : SampleModel){
            binding.apply {
                tvId.text = item.id.toString()
                tvName.text = item.name
            }
        }
    }

    private val differCallback = object : DiffUtil.ItemCallback<SampleModel>(){
        override fun areItemsTheSame(oldItem: SampleModel, newItem: SampleModel): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: SampleModel, newItem: SampleModel): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this,differCallback)
}

