package com.example.feature_select_country.view.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.feature_select_country.databinding.TicketItemBinding
import com.example.data.model.select_country_model.TicketsOffer

class TicketAdapter(
    private val tickets : List<com.example.data.model.select_country_model.TicketsOffer>
) : RecyclerView.Adapter<TicketViewHolder>() {
    override fun onCreateViewHolder(parent : ViewGroup, viewType : Int) : TicketViewHolder {

        val view = TicketItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return TicketViewHolder(view)
    }

    override fun getItemCount() : Int = tickets.size

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder : TicketViewHolder, position : Int) {

        val tickets = tickets[position]

        holder.bind(tickets)

    }


}

class TicketViewHolder(val binding : TicketItemBinding) : RecyclerView.ViewHolder(binding.root) {

    @SuppressLint("SetTextI18n")
    fun bind(tickets : com.example.data.model.select_country_model.TicketsOffer) {
        binding.apply {
            val timeRangeText = tickets.time_range.joinToString(" ")
            tvTime.text = tickets.title
            tvPrice.text = "от ${tickets.price.value}₽"
            tvTown.text = timeRangeText
        }
    }

}