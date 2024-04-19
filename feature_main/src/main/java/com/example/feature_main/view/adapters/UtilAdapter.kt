package com.example.feature_main.view.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.feature_main.databinding.UtilItemBinding
import com.example.feature_main.domain.model.search_model.Util

class UtilAdapter(
    private val utilList : List<Util>
) : RecyclerView.Adapter<UtilViewHolder>() {
    override fun onCreateViewHolder(parent : ViewGroup, viewType : Int) : UtilViewHolder {

        val view = UtilItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return UtilViewHolder(view)
    }

    override fun getItemCount() : Int = utilList.size

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder : UtilViewHolder, position : Int) {

        val util = utilList[position]

        holder.binding.apply {

            tvTitle.text = util.title
            imUtil.setImageResource(util.image)
            imUtil.setBackgroundResource(util.color)
        }

    }


}

class UtilViewHolder(val binding : UtilItemBinding) : RecyclerView.ViewHolder(binding.root)
