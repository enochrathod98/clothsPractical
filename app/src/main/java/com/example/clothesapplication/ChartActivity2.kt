package com.example.clothesapplication

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.clothesapplication.adapters.CartAdapter
import com.example.clothesapplication.adapters.SubCategoryAdapter
import com.example.clothesapplication.databinding.ActivityChart2Binding
import com.example.clothesapplication.model.CartItem
import com.example.clothesapplication.model.CartManager

class ChartActivity2 : AppCompatActivity() {

    lateinit var binding: ActivityChart2Binding
    private lateinit var cartAdapter: CartAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityChart2Binding.inflate(layoutInflater)
        setContentView(binding.root)
      /*  ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }*/
        setView()
    }

    private fun setView() {
        val cartItems = CartManager.getCartItems()

        cartAdapter = CartAdapter(cartItems)
        binding.recyclerView.adapter = cartAdapter
    }
}