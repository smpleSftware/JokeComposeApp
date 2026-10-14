package com.example.jokecomposeapp.service

import com.example.jokecomposeapp.model.JokeModel
import retrofit2.http.GET

interface JokeAPI {

    @GET("atilsamancioglu/ProgrammingJokesJSON/refs/heads/main/jokes.json")
    suspend fun getJokes(): List<JokeModel>

}