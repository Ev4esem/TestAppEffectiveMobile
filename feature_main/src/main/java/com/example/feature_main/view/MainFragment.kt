package com.example.feature_main.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.base.observeEffect
import com.example.feature_main.databinding.MainScreenBinding
import com.example.feature_main.view.adapter.OfferAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainFragment : Fragment() {

    lateinit var binding : MainScreenBinding


    private val mainViewModel: MainViewModel by viewModel()


    override fun onCreateView(
        inflater : LayoutInflater,
        container : ViewGroup?,
        savedInstanceState : Bundle?
    ) : View {


        binding = MainScreenBinding.inflate(inflater, container, false)


        return binding.root
    }

    override fun onViewCreated(view : View, savedInstanceState : Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val uiState = mainViewModel.uiState.value

        val offerAdapter = OfferAdapter(uiState.offerList)

        binding.rvOffers.adapter = offerAdapter

        binding.tvDestinationTown.setOnFocusChangeListener { view, hasFocus ->

            if (hasFocus) {
                val bottomSheetFragment = SearchBottomSheetFragment()
                bottomSheetFragment.show(childFragmentManager, bottomSheetFragment.tag)
            }

        }


        observeEffect(this, mainViewModel.effectFlow) { effect ->
            when(effect) {
                is MainEffect.ShowToast -> {
                    Toast.makeText(context, effect.message, Toast.LENGTH_LONG).show()
                }
            }
        }

    }

}