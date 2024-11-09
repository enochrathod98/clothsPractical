package com.example.clothesapplication.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.clothesapplication.R
import com.example.clothesapplication.model.Service

class ServiceAdapter(
    private val services: List<Service>,
    private val onCheckedChange: (Service, Boolean) -> Unit
) : RecyclerView.Adapter<ServiceAdapter.ServiceViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ServiceViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_service, parent, false)
        return ServiceViewHolder(view)
    }

    override fun onBindViewHolder(holder: ServiceViewHolder, position: Int) {
        val service = services[position]
        holder.bind(service)
    }

    override fun getItemCount(): Int {
        return services.size
    }

    inner class ServiceViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val serviceCheckBox: CheckBox = itemView.findViewById(R.id.serviceCheckBox)

        fun bind(service: Service) {
            serviceCheckBox.text = service.service_name
            serviceCheckBox.setOnCheckedChangeListener { _, isChecked ->
                onCheckedChange(service, isChecked)
            }
        }
    }
}