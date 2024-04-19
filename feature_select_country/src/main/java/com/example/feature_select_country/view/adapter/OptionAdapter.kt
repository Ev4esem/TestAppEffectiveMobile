package com.example.feature_select_country.view.adapter

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.feature_select_country.databinding.OptionItemBinding
import com.example.feature_select_country.domain.model.Option
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class OptionAdapter(
    private val utilList : List<Option>
) : RecyclerView.Adapter<OptionViewHolder>() {




    override fun onCreateViewHolder(parent : ViewGroup, viewType : Int) : OptionViewHolder {

        val view = OptionItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return OptionViewHolder(view)
    }

    override fun getItemCount() : Int = utilList.size

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder : OptionViewHolder, position : Int) {

        val option = utilList[position]

        holder.bind(option)

    }


}

class OptionViewHolder(val binding : OptionItemBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(option : Option) {
        binding.tvTitle.text = option.title
        binding.image.setImageResource(option.image)
        binding.root.setOnClickListener {
            if (option.id == "calendar" ) {
                showDatePickerDialog("calendar")
            } else if (option.id == "add") {
                showDatePickerDialog("add")
            }
        }
    }


    private fun showDatePickerDialog(optionId : String) {
        val currentDate = Calendar.getInstance()
        val year = currentDate.get(Calendar.YEAR)
        val month = currentDate.get(Calendar.MONTH)
        val dayOfMonth = currentDate.get(Calendar.DAY_OF_MONTH)
        val datePickerDialog = DatePickerDialog( binding.root.context, { _, selectedYear, selectedMonth, selectedDayOfMonth ->

            val selectedDate = Calendar.getInstance().apply {
                set(selectedYear, selectedMonth, selectedDayOfMonth)
            }
            if (optionId == "calendar") {
                updateText(selectedDate)
            }
        }, year, month, dayOfMonth)
        datePickerDialog.show()
    }

    private fun updateText(selectedTime: Calendar) {

        val formattedTime = SimpleDateFormat("dd MMMM", Locale.getDefault()).format(selectedTime.time)
        binding.tvTitle.text = formattedTime
    }

}
