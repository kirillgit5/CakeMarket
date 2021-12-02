package com.example.myapplication.ui.menu

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.ItemCakeVhBinding

internal class CakeAdapter : RecyclerView.Adapter<CakeView>() {

    private var cakes = mutableListOf<CakeViewModel>()

    fun reload(newCakes: List<CakeViewModel>){
        cakes.clear()
        cakes.addAll(newCakes)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CakeView {
        val inflater = LayoutInflater.from(parent.context)
        return CakeView(ItemCakeVhBinding.inflate(inflater, parent, false))
    }

    override fun onBindViewHolder(holder: CakeView, position: Int) {
        holder.bind(cakes[position])
    }

    override fun getItemCount(): Int = cakes.size
}