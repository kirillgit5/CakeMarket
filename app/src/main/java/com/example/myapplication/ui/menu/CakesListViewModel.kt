package com.example.myapplication.ui.menu

import android.app.Application
import androidx.lifecycle.*
import com.example.myapplication.App
import com.example.myapplication.network.CakeProvider
import kotlinx.coroutines.launch

class CakesListViewModel(application: Application) : AndroidViewModel(application) {
    private val cakes: MutableLiveData<List<CakeViewModel>> = MutableLiveData()
    private val cakeProvider = CakeProvider()

    init {
        loadCakes()
    }

    fun getCakes(): LiveData<List<CakeViewModel>> {
        return cakes
    }
    private fun loadCakes(){
        viewModelScope.launch {
            cakes.postValue(cakeProvider.getCakes().map { CakeViewModel(getApplication<App>(), it) })
        }
    }

    class Factory(private val application: Application) : ViewModelProvider.Factory {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return CakesListViewModel(application) as T
        }
    }
}