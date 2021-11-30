package com.example.starwarsdatabase.api

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface ApiService {

    @GET("/api/people/{id}/")
    suspend fun getSpecificCharacter(@Path("id") peopleId: String): Message

    @GET("/api/people/")
    suspend fun getCharacterByPage(@Query("page") pageNumber: String): Characters


}