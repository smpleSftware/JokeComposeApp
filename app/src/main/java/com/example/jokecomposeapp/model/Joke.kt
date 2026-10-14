package com.example.jokecomposeapp.model

data class Joke(
    val type: String,
    val joke: String? = null,
    val setup: String? = null,
    val delivery: String? = null
)