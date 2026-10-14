package com.example.jokecomposeapp.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.jokecomposeapp.model.Joke

@Composable
fun JokeListScreen(jokeList: List<Joke>) {
    Scaffold(modifier = Modifier.fillMaxSize()) {innerPadding->
        LazyColumn(contentPadding = innerPadding) {
            items(jokeList) {
                JokeRow(it)
            }
        }
    }
}

@Composable
private fun JokeRow(joke: Joke) {
    HorizontalDivider(thickness = 5.dp, color = Color.Black)
    Box (
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = joke.type,
            modifier = Modifier.align(Alignment.TopEnd)
                .padding(end = 5.dp)
        )
        Column(
            modifier = Modifier.align(Alignment.TopStart)
                .padding(vertical = 20.dp, horizontal = 10.dp)
        ) {
            if (joke.type == "single"){
                joke.joke?.let {
                    Text(text = it)
                }
            }else {
                if (!joke.setup.isNullOrBlank() && !joke.delivery.isNullOrBlank()){
                    Text(text = joke.setup)
                    Text(text = joke.delivery)
                }
            }
        }
    }
}