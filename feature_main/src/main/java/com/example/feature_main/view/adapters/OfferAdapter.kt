package com.example.feature_main.view.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.feature_main.databinding.OfferItemBinding
import com.example.data.model.main_model.Offer

internal class OfferAdapter(
    private val offersList : List<com.example.data.model.main_model.Offer>
) : RecyclerView.Adapter<OfferViewHolder>() {
    override fun onCreateViewHolder(parent : ViewGroup, viewType : Int) : OfferViewHolder {

        val view = OfferItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return OfferViewHolder(view)
    }

    override fun getItemCount() : Int = offersList.size

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder : OfferViewHolder, position : Int) {

        val offer = offersList[position]

        holder.binding.apply {

            tvTitle.text = offer.title
            tvPrice.text = "от ${offer.price.value}₽"
            tvTown.text = offer.town

        }

    }


}

class OfferViewHolder(val binding : OfferItemBinding) : RecyclerView.ViewHolder(binding.root)
