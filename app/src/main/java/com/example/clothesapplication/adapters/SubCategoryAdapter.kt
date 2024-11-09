package com.example.clothesapplication.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.clothesapplication.R
import com.example.clothesapplication.model.Product
import com.example.clothesapplication.model.Service
import com.example.clothesapplication.model.SubCategory

class SubCategoryAdapter(
    private val subCategories: List<SubCategory>,
    private val products: List<Product>,
    private val services: MutableList<Service>
) : RecyclerView.Adapter<SubCategoryAdapter.SubCategoryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubCategoryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.sub_category_item_layout, parent, false)
        return SubCategoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: SubCategoryViewHolder, position: Int) {
        val subCategory = subCategories[position]
        holder.bind(subCategory, products)
    }

    override fun getItemCount(): Int {
        return subCategories.size
    }

    inner class SubCategoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val subCategoryName: TextView = itemView.findViewById(R.id.subCategoryName)
        private val expandButton: ImageView = itemView.findViewById(R.id.expandButton)
        private val productRecyclerView: RecyclerView = itemView.findViewById(R.id.productRecyclerView)

        fun bind(subCategory: SubCategory, products: List<Product>) {
            subCategoryName.text = subCategory.sub_category_name

            val filteredProducts = products.filter { it.sub_category_id == subCategory.sub_category_id }
            val productAdapter = ProductAdapter(filteredProducts,services)

            productRecyclerView.layoutManager = LinearLayoutManager(itemView.context)
            productRecyclerView.adapter = productAdapter

            expandButton.setOnClickListener {
                if (productRecyclerView.visibility == View.GONE) {
                    productRecyclerView.visibility = View.VISIBLE
                } else {
                    productRecyclerView.visibility = View.GONE
                }
            }
        }
    }
}