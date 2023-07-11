package com.vishalag53.marsrealestate.overview

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vishalag53.marsrealestate.network.MarsApi
import com.vishalag53.marsrealestate.network.MarsProperty
import kotlinx.coroutines.launch

class OverviewViewModel : ViewModel() {

    private val _status = MutableLiveData<String>()

    val status: LiveData<String>
        get() = _status

    private val _properties = MutableLiveData<List<MarsProperty>>()
    val properties: LiveData<List<MarsProperty>>
        get() = _properties

    init {
        getMarsRealEstateProperties()
    }

    private fun getMarsRealEstateProperties() {
        viewModelScope.launch {
            try {
                var listResult = MarsApi.retrofitService.getProperties()
                _status.value = "Success: ${listResult.size} Mars properties retrieved"
                if(listResult.isNotEmpty()){
                    _properties.value = listResult
                }
            } catch (e: Exception) {
                _status.value = "Failure: ${e.message} "
            }

        }
    }

}