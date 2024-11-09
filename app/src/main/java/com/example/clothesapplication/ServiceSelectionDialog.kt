package com.example.clothesapplication

import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.clothesapplication.adapters.CartAdapter
import com.example.clothesapplication.adapters.ServiceAdapter
import com.example.clothesapplication.model.CartItem
import com.example.clothesapplication.model.CartManager
import com.example.clothesapplication.model.Product
import com.example.clothesapplication.model.Service

class ServiceSelectionDialog(
    context: Context,
    private val product: Product,
    private val services: MutableList<Service>
) : Dialog(context) {

    private val selectedServices = mutableListOf<Service>()

    init {
        setContentView(R.layout.dialog_service_selection)

        val serviceRecyclerView: RecyclerView = findViewById(R.id.serviceRecyclerView)
        val serviceAdapter = ServiceAdapter(services) { service, isChecked ->
            if (isChecked) {
                selectedServices.add(service)
            } else {
                selectedServices.remove(service)
            }
        }

        serviceRecyclerView.layoutManager = LinearLayoutManager(context)
        serviceRecyclerView.adapter = serviceAdapter

        findViewById<Button>(R.id.addButton).setOnClickListener {
            addToCart()
        }
    }

    private fun addToCart() {
        if (selectedServices.isNotEmpty()) {
            val cartItem = CartItem(product.product_name, selectedServices)
            CartManager.addToCart(cartItem)
            Toast.makeText(context, "added to cart", Toast.LENGTH_SHORT).show()
            val intent = Intent(context, ChartActivity2::class.java)
            context.startActivity(intent)
            dismiss() // Close the dialog
        }
    }
}