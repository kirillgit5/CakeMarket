package com.example.myapplication.ui.menu

import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.example.myapplication.R
import com.example.myapplication.BR
import com.example.myapplication.databinding.ItemCakeVhBinding

class CakeView(private val binding: ItemCakeVhBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(viewModel: CakeViewModel){
        binding.apply {
            setVariable(BR.viewModel, viewModel)
            cakeName.text = viewModel.cake.name
            cakePrice.text = "${viewModel.cake.price.toString()} руб."
            cakeWeight.text = "${viewModel.cake.weight.toString()} г."
            cakeCalories.text = "${viewModel.cake.calories.toString()} кк."

            Picasso.get()
                .load("${R.string.baseurl}/${viewModel.cake.image}")
                .into(cakeImg)
        }
    }
}