package com.example.myapplication.ui.menu

import android.app.Application
import android.os.Bundle
import androidx.lifecycle.AndroidViewModel
import com.example.myapplication.App
import com.example.myapplication.model.Cake
import com.example.myapplication.ui.menu.cakeInfo.CakeDetailsFragment

class CakeViewModel(application: Application, val cake: Cake) : AndroidViewModel(application) {
        fun onClick(){
            val cakeDetailFragment = CakeDetailsFragment()
            val bundle = Bundle()
            bundle.putLong("ARG_CAKE_ID", cake.id ?: 1)
            cakeDetailFragment.arguments = bundle
            getApplication<App>().mainRouter.changeMainFragment(cakeDetailFragment)
        }
}
