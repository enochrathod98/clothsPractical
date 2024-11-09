package com.example.clothesapplication.model

object CartManager {
    private val cartItems = mutableListOf<CartItem>()

    fun addToCart(cartItem: CartItem) {
        cartItems.add(cartItem)
    }

    fun getCartItems(): List<CartItem> {
        return cartItems
    }

    fun clearCart() {
        cartItems.clear()
    }
}