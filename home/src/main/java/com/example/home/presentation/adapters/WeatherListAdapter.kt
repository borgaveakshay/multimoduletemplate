package com.example.home.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.home.R
import com.example.home.databinding.WeatherItemLayoutBinding
import com.example.models.GetWeatherResponse

class WeatherListAdapter : RecyclerView.Adapter<WeatherListAdapter.WeatherViewHolder>() {

    private val list = mutableListOf<GetWeatherResponse>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        WeatherViewHolder(
             DataBindingUtil.inflate(
                  LayoutInflater.from(parent.context),
                  R.layout.weather_item_layout,
                  parent,
                  false
             )
        )

    override fun onBindViewHolder(holder: WeatherViewHolder, position: Int) =
        holder.bind(list[position])

    override fun getItemCount() = list.size

    fun updateList(updatedList: List<GetWeatherResponse>) {
        list.clear()
        list.addAll(updatedList)
        notifyDataSetChanged()
    }

    class WeatherViewHolder(private val binding: WeatherItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(weatherResponse: GetWeatherResponse) {
            binding.weatherItem = weatherResponse
        }
    }
}