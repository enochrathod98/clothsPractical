package com.example.clothesapplication.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.clothesapplication.R
import com.example.clothesapplication.ServiceSelectionDialog
import com.example.clothesapplication.model.Product
import com.example.clothesapplication.model.Service

class ProductAdapter(private val products: List<Product>, private val services: MutableList<Service>) : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.product_item_layout, parent, false)
        return ProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = products[position]
        holder.bind(product)
    }

    override fun getItemCount(): Int {
        return products.size
    }

    inner class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val productName: TextView = itemView.findViewById(R.id.productTitle)
        private val addButton: Button = itemView.findViewById(R.id.addButton)
        private val icon: ImageView = itemView.findViewById(R.id.icon)


        fun bind(product: Product) {
            productName.text = product.product_name
            Glide.with(itemView).load(product.product_photo).circleCrop().into(icon)
            addButton.setOnClickListener {
                showServiceSelectionDialog(product,services)
            }
        }

        private fun showServiceSelectionDialog(product: Product, services: MutableList<Service>) {
            val dialog = ServiceSelectionDialog(itemView.context, product,services)
            dialog.show()
        }
    }
}