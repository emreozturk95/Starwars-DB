package com.example.starwarsdatabase.repository

import com.example.starwarsdatabase.api.ApiService

class Repository(
    private val apiService: ApiService
) {
    suspend fun getCharacterByPage(page: String) = apiService.getCharacterByPage(page)
    suspend fun getSpecificCharacter(character: String) = apiService.getSpecificCharacter(character)
}