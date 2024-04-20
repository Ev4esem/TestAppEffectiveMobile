package com.example.feature_main.view.fragments

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.HORIZONTAL
import androidx.recyclerview.widget.RecyclerView.VERTICAL
import com.example.feature_main.databinding.SearchBottomSheetBinding
import com.example.feature_main.view.MainViewModel
import com.example.feature_main.view.adapters.TownAdapter
import com.example.feature_main.view.adapters.UtilAdapter
import com.example.navigation.NavigationFlow
import com.example.navigation.ToFlowNavigatable
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class SearchBottomSheetFragment(
    private val mainViewModel : MainViewModel
) : BottomSheetDialogFragment() {

    lateinit var binding : SearchBottomSheetBinding


    override fun onCreateView(
        inflater : LayoutInflater,
        container : ViewGroup?,
        savedInstanceState : Bundle?
    ) : View {


        binding = SearchBottomSheetBinding.inflate(inflater, container, false)

        dialog?.window?.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )


        return binding.root
    }

    override fun onCreateDialog(savedInstanceState : Bundle?) : Dialog {

        val dialog = BottomSheetDialog(requireContext(), theme)
        dialog.setOnShowListener { it ->
            val bottomSheetDialog = it as BottomSheetDialog
            val parentLayout =
                bottomSheetDialog.findViewById<View>(com.google.android.material.R.id.design_bottom_sheet)
            parentLayout?.let {
                val behavior = BottomSheetBehavior.from(it)
                setupFullHeight(it)
                behavior.state = BottomSheetBehavior.STATE_EXPANDED
            }
        }

        return dialog
    }

    private fun setupFullHeight(bottomSheet : View) {
        val layoutParams = bottomSheet.layoutParams
        layoutParams.height = WindowManager.LayoutParams.MATCH_PARENT
        bottomSheet.layoutParams = layoutParams
    }

    override fun onViewCreated(view : View, savedInstanceState : Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val uiState = mainViewModel.uiState.value


        val utilAdapter = UtilAdapter(uiState.utils)
        val townAdapter = TownAdapter(uiState.townList)
        binding.rvTown.layoutManager = LinearLayoutManager(requireContext(), VERTICAL, false)
        binding.rvUtil.layoutManager = LinearLayoutManager(requireContext(), HORIZONTAL, false)
        binding.rvTown.adapter = townAdapter
        binding.rvUtil.adapter = utilAdapter
        binding.tvDestinationTown.requestFocus()

        if (binding.tvDestinationTown.text?.length != 0) {

            val city = binding.tvTown.text.toString()
            val destination = binding.tvDestinationTown.text.toString()

            (requireActivity() as ToFlowNavigatable).navigateToFlow(
                NavigationFlow.SelectCountryFlow(
                    city, destination
                )
            )
        }

    }


}