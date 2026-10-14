package com.example.jokecomposeapp.viewmodel

import android.app.Application
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.jokecomposeapp.model.Joke
import com.example.jokecomposeapp.service.JokeAPI
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class JokeViewModel(application: Application): AndroidViewModel(application) {

    private val BASE_URL = "https://raw.githubusercontent.com/"
    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build().create(JokeAPI::class.java)

    val jokeList = mutableStateOf<List<Joke>>(listOf())

    init {
        viewModelScope.launch {
            val jokeApiModel = retrofit.getJokes()

            jokeApiModel
                .map { it -> Joke(type = it.type, joke = it.joke, setup = it.setup, delivery = it.delivery) }
                .also {
                    jokeList.value = it
                }
        }
    }




}