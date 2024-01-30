package com.saintek.mdh.harahjawoetranslation.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.saintek.mdh.harahjawoetranslation.data.repository.AppRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MainViewModel(private val appRepository: AppRepository): ViewModel() {

    private val mutableStateFlow = MutableStateFlow(true)
    val isFirstTime = mutableStateFlow.asStateFlow()

    init {
        viewModelScope.launch {
            delay(2000)
//            mutableStateFlow.value = appRepository.checkIsFirstTimeLaunch()
            mutableStateFlow.value = false
        }
    }
}