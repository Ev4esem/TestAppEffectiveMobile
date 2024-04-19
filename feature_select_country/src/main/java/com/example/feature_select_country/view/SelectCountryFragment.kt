package com.example.feature_select_country.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.HORIZONTAL
import androidx.recyclerview.widget.RecyclerView.VERTICAL
import com.example.base.navigationToDeepLink
import com.example.feature_select_country.databinding.SelectCountryScreenBinding
import com.example.feature_select_country.view.adapter.OptionAdapter
import com.example.feature_select_country.view.adapter.TicketAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class SelectCountryFragment : Fragment() {

    private val viewModel : SelectCountryViewModel by viewModel()
    lateinit var binding : SelectCountryScreenBinding

    override fun onCreateView(
        inflater : LayoutInflater,
        container : ViewGroup?,
        savedInstanceState : Bundle?
    ) : View {

        binding = SelectCountryScreenBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view : View, savedInstanceState : Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val uiState = viewModel.uiState.value

        binding.rvTickets.layoutManager = LinearLayoutManager(requireContext(), VERTICAL, false)
        binding.rvOptions.layoutManager = LinearLayoutManager(requireContext(), HORIZONTAL, false)
        val optionAdapter = OptionAdapter(uiState.options)
        val ticketsAdapter = TicketAdapter(uiState.tickets)
        binding.rvOptions.adapter = optionAdapter
        binding.rvTickets.adapter = ticketsAdapter

        binding.bAllTickets.setOnClickListener {

        }

    }




}