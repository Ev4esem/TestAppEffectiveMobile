package com.example.feature_main.view.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.feature_main.databinding.TownItemBinding
import com.example.data.model.search_model.Town


class TownAdapter(
    private val utilList : List<com.example.data.model.search_model.Town>
) : RecyclerView.Adapter<TownViewHolder>() {
    override fun onCreateViewHolder(parent : ViewGroup, viewType : Int) : TownViewHolder {

        val view = TownItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return TownViewHolder(view)
    }

    override fun getItemCount() : Int = utilList.size

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder : TownViewHolder, position : Int) {

        val town = utilList[position]

        holder.binding.apply {

            tvTown.text = town.title
            imTown.setImageResource(town.image)
        }

    }


}

class TownViewHolder(val binding : TownItemBinding) : RecyclerView.ViewHolder(binding.root)
