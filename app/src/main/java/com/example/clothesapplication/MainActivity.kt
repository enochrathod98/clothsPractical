package com.example.clothesapplication

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.clothesapplication.adapters.SubCategoryAdapter
import com.example.clothesapplication.databinding.ActivityMainBinding
import com.example.clothesapplication.model.Product
import com.example.clothesapplication.model.Service
import com.example.clothesapplication.model.SubCategory
import com.example.clothesapplication.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private val mainViewModel: MainViewModel by viewModels()
    private lateinit var subCategoryAdapter: SubCategoryAdapter

    private val subCategories = mutableListOf<SubCategory>()
    private val products = mutableListOf<Product>()
    private val services = mutableListOf<Service>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        /*   ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
               val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
               v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
               insets
           }*/

        setView()
    }

    private fun setView() {

        binding.cartImv.setOnClickListener {
            val intent = Intent(this, ChartActivity2::class.java)
            startActivity(intent)
        }

        mainViewModel.data.observe(this) {/**/
            Log.e("STATUS $$", it.data.toString())
            if (it.data != null) {
                for (i in it.data.sub_categories.indices) {
                    subCategories.add(it.data.sub_categories[i])
                }

                for (j in it.data.products.indices) {
                    products.add(it.data.products[j])
                }

                for (k in it.data.services.indices) {
                    services.add(it.data.services[k])
                }

                subCategoryAdapter = SubCategoryAdapter(subCategories, products, services)
                binding.recyclerView.adapter = subCategoryAdapter
            }
        }
    }
}