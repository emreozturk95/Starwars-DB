package com.example.starwarsdatabase.main.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.starwarsdatabase.api.Properties
import com.example.starwarsdatabase.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(private val repository: Repository) : ViewModel() {
    var loading = MutableLiveData<Boolean>()
    var error = MutableLiveData<Boolean>()
    var uid = MutableLiveData<String>()
    var characterProperties = MutableLiveData<Properties>()
    var characterPropertiesVisibility = MutableLiveData<Boolean>()

    fun fetchCharacterDetails() {
        viewModelScope.launch(Dispatchers.IO) {
            loading.postValue(true)
            try {
                characterProperties.postValue(repository.getSpecificCharacter(uid.value!!).result.properties)
                characterPropertiesVisibility.postValue(true)
            } catch (e: Exception) {
                error.postValue(true)
            }
            loading.postValue(false)
        }
    }

}