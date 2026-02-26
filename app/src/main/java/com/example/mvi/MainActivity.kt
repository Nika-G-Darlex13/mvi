package com.example.mvi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mvi.ui.library.LibraryIntent
import com.example.mvi.ui.library.LibraryScreen
import com.example.mvi.ui.library.LibraryViewModel
import com.example.mvi.ui.search.SearchScreen
import com.example.mvi.ui.search.SearchViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                val navController = rememberNavController()

                NavHost(navController = navController, startDestination = "search") {

                    composable("search") {
                        val searchViewModel: SearchViewModel = viewModel()
                        val state by searchViewModel.state

                        SearchScreen(
                            state = state,
                            navController = navController,
                            onAction = { intent -> searchViewModel.handleIntent(intent) }
                        )
                    }

                    composable("library") {
                        val libraryViewModel: LibraryViewModel = viewModel()
                        val state by libraryViewModel.state

                        LibraryScreen(
                            state = state,
                            onAction = { intent ->
                                when (intent) {
                                    is LibraryIntent.OnBackClicked -> navController.popBackStack()
                                    is LibraryIntent.LoadBooks -> libraryViewModel.handleIntent(intent)
                                }
                            }
                        )
                    }
                }
            }
        }
    }
}


