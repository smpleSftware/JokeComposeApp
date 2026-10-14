package com.example.jokecomposeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import com.example.jokecomposeapp.screen.JokeListScreen
import com.example.jokecomposeapp.ui.theme.JokeComposeAppTheme
import com.example.jokecomposeapp.viewmodel.JokeViewModel

class MainActivity : ComponentActivity() {

    private val viewModel: JokeViewModel by viewModels<JokeViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JokeComposeAppTheme {
                JokeListScreen(viewModel.jokeList.value)
            }
        }
    }
}