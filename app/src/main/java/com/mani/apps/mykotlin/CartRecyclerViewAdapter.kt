package com.mani.apps.mykotlin

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.mani.apps.mykotlin.databinding.CartViewItemBinding

class CartRecyclerViewAdapter(val context: Context) : RecyclerView.Adapter<CardViewHolder>() {

    private lateinit var personList: MutableList<Person>

    fun setItems(personList: MutableList<Person>) {
        this.personList = personList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val inflater = LayoutInflater.from(context)
        val binding = CartViewItemBinding.inflate(inflater)
        return CardViewHolder(binding!!)
    }

    override fun getItemCount(): Int {
        return personList.size
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        holder.binding.person = personList[position]
    }
}

class CardViewHolder(var binding: CartViewItemBinding) : RecyclerView.ViewHolder(binding.root)
