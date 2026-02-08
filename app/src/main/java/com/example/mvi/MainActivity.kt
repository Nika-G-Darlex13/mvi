package com.example.mvi


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mvi.ui.theme.BookScreen.LibraryScreen
import com.example.mvi.ui.theme.BookScreen.SearchScreen
import com.example.mvi.ui.theme.BookViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                val navController = rememberNavController()

                val viewModel: BookViewModel = viewModel()

                NavHost(navController = navController, startDestination = "search") {

                    composable("search") {
                        SearchScreen(navController, viewModel)
                    }

                    composable("library") {
                        LibraryScreen(navController, viewModel)
                    }
                }
            }
        }
    }
}
