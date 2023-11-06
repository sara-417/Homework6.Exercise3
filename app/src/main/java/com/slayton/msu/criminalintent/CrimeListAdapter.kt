package com.slayton.msu.criminalintent


import android.text.format.DateFormat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.slayton.msu.criminalintent.databinding.ListItemCrimeBinding
import java.util.*

class CrimeHolder (
    private val binding: ListItemCrimeBinding
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(crime: Crime) {
        binding.crimeTitle.text = crime.title
//        call the function and pass the date as a parameter
        binding.crimeDate.text = formatDate(crime.date)

        binding.root.setOnClickListener {
            Toast.makeText(
                binding.root.context,
                "${crime.title} clicked!",
                Toast.LENGTH_SHORT
            ).show()
        }

        binding.crimeSolved.visibility = if(crime.isSolved) {
            View.VISIBLE
        } else {
            View.GONE
        }

        }
    }
// create a function to handle formatting the date
    private fun formatDate(date: Date): String {
        val pattern = "EEE, MMMM d, yyyy"
        return DateFormat.format(pattern, date) as String
    }

class CrimeListAdapter(
    private val crimes: List<Crime>
): RecyclerView.Adapter<CrimeHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CrimeHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ListItemCrimeBinding.inflate(inflater, parent, false)
        return CrimeHolder(binding)
    }

    override fun onBindViewHolder(holder: CrimeHolder, position: Int) {
        val crime = crimes[position]
        holder.bind(crime)
    }

    override fun getItemCount() = crimes.size

}