package com.example.feature_main.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.feature_main.databinding.SearchBottomSheetBinding
import com.example.feature_main.view.adapter.TownAdapter
import com.example.feature_main.view.adapter.UtilAdapter
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class SearchBottomSheetFragment : BottomSheetDialogFragment() {

    private val mainViewModel : MainViewModel by viewModel<MainViewModel>()
    lateinit var binding : SearchBottomSheetBinding


    override fun onCreateView(
        inflater : LayoutInflater,
        container : ViewGroup?,
        savedInstanceState : Bundle?
    ) : View {


        binding = SearchBottomSheetBinding.inflate(inflater, container, false)

        dialog?.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)


        return binding.root
    }

    override fun onViewCreated(view : View, savedInstanceState : Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val uiState = mainViewModel.uiState.value

        val townAdapter = TownAdapter(uiState.townList)
        val utilAdapter = UtilAdapter(uiState.utils)

        binding.rvTown.adapter = townAdapter
        binding.rvUtil.adapter = utilAdapter
    }

}