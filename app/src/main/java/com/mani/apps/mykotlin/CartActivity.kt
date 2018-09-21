package com.mani.apps.mykotlin

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.cart_view.*

class CartActivity : AppCompatActivity() {

    lateinit var cartViewModelNew: CartViewModelNew

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.cart_view)
        cartViewModelNew = ViewModelProviders.of(this).get(CartViewModelNew::class.java)
        val cartRecyclerViewAdapter = CartRecyclerViewAdapter(this)

        val list = cartViewModelNew.getPersonList().value

        cartViewModelNew.getPersonList().observe(this, Observer { persons ->
            if (persons != null) {
                cartRecyclerViewAdapter.setItems(persons)
                cart_recycler_view.adapter = cartRecyclerViewAdapter
            }
        })

    }
}