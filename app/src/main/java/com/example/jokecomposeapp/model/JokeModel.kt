package com.example.jokecomposeapp.model

data class JokeModel (
    val error: Boolean,
    val category: String,
    val type: String,
    val setup: String?,
    val delivery: String?,
    val flags: Flags,
    val id: Long,
    val safe: Boolean,
    val lang: String,
    val joke: String?,
)

data class Flags (
    val nsfw: Boolean,
    val religious: Boolean,
    val political: Boolean,
    val racist: Boolean,
    val sexist: Boolean,
    val explicit: Boolean,
)
