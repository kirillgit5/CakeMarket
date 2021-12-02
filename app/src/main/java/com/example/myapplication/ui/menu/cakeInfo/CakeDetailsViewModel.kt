package com.example.myapplication.ui.menu.cakeInfo

import android.app.Application
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.databinding.ObservableField
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.R
import com.example.myapplication.model.CakeFullInfo
import com.example.myapplication.network.CakeProvider
import com.squareup.picasso.Picasso
import kotlinx.coroutines.launch

@BindingAdapter("app:picasso")
fun image(view: ImageView, path: String?) {
    Picasso.get().load("${R.string.baseurl}/${path}")
        .placeholder(R.drawable.cake)
        .error(R.drawable.cake)
        .into(view)
}

class CakeDetailsViewModel(application: Application) : AndroidViewModel(application) {
    private var cakeDetail = CakeFullInfo.emptyObject()
    private val cakeProvider = CakeProvider()

    fun loadData(id: Long){
        viewModelScope.launch {
            cakeDetail = cakeProvider.getCakeInfo(id)
            cakeDetail.run{
                nameObs.set(name)
                caloriesObs.set(calories.toString())
                imgObs.set(image)
                priceObs.set(price.toString())
                weightObs.set(weight.toString())
                manufacturerObj.set(manufacturerName)
                storageConditionsObs.set(storageConditions)
            }
        }
    }

    val nameObs = object : ObservableField<String>(){
        override fun get(): String?{
            return cakeDetail.name
        }
    }

    val caloriesObs = object : ObservableField<String>(){
        override fun get(): String? {
            return "${cakeDetail.calories.toString()} ккал."
        }
    }

    val imgObs = object : ObservableField<String>() {
        override fun get(): String?{
            return cakeDetail.image
        }
    }

    val priceObs = object : ObservableField<String>(){
        override fun get(): String?{
            return "${cakeDetail.price.toString()} руб."
        }
    }

    val weightObs = object : ObservableField<String>(){
        override fun get(): String?{
            return "${cakeDetail.weight.toString()} г."
        }
    }

    val manufacturerObj = object : ObservableField<String>(){
        override fun get(): String?{
            return "Состав: \n${cakeDetail.manufacturerName}"
        }
    }

    val storageConditionsObs = object : ObservableField<String>(){
        override fun get(): String?{
            return "Условия хранения: \n${cakeDetail.storageConditions}"
        }
    }
}