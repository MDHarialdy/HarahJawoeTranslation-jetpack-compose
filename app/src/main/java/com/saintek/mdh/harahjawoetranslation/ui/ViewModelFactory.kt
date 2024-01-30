package com.saintek.mdh.harahjawoetranslation.ui

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.saintek.mdh.harahjawoetranslation.data.injection.DataInjection
import com.saintek.mdh.harahjawoetranslation.data.repository.AppRepository

@Suppress("UNCHECKED_CAST")
class ViewModelFactory(private val repository: AppRepository): ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when{
            modelClass.isAssignableFrom(MainViewModel::class.java) -> {
                MainViewModel(repository) as T
            }
            else -> throw IllegalArgumentException("Unknown ViewModel Class: "+ modelClass.name)
        }
    }

    companion object {
        @Volatile
        private var INSTANCE: ViewModelFactory? = null

        fun getInstance(context: Context): ViewModelFactory {
            if (INSTANCE == null){
                synchronized(this){
                    INSTANCE = ViewModelFactory(DataInjection.provideRepository(context))
                }
            }
            return INSTANCE as ViewModelFactory
        }
    }
}