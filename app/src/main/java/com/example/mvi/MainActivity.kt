package com.example.mvi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
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
                        SearchScreen(navController, searchViewModel)
                    }

                    composable("library") {
                        val libraryViewModel: LibraryViewModel = viewModel()
                        LibraryScreen(navController, libraryViewModel)
                    }
                }
            }
        }
    }
}
