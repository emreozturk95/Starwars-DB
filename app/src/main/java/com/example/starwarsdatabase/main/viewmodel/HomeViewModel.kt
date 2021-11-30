package com.example.starwarsdatabase.main.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.starwarsdatabase.api.Characters
import com.example.starwarsdatabase.main.view.HomeFragment
import com.example.starwarsdatabase.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val repository: Repository) : ViewModel() {

    var loading = MutableLiveData<Boolean>()
    var error = MutableLiveData<Boolean>()
    var characters = MutableLiveData<Characters>()

    fun fetchCharacters() {
        viewModelScope.launch(Dispatchers.IO) {
            loading.postValue(true)
            try {
                val response = repository.getCharacterByPage("1")
                characters.postValue(response)
            } catch (e: Exception) {
                error.postValue(true)
            }
            loading.postValue(false)
        }

    }

}