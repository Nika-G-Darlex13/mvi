package com.example.mvi.ui.library

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.compose.material3.Button
import androidx.compose.runtime.LaunchedEffect
import com.example.mvi.ui.BookListComponent
import com.example.mvi.ui.theme.PinkColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LibraryScreen(navController: NavHostController, viewModel: LibraryViewModel) {
    LaunchedEffect(Unit) {
        viewModel.handleIntent(LibraryIntent.LoadBooks)
    }
    val state by viewModel.state

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Моя библиотека") },
                navigationIcon = {
                    Button(
                        onClick = { navController.popBackStack() },
                        colors = ButtonDefaults.buttonColors(containerColor = PinkColor)
                    ) {
                        Text("Назад")
                    }
                }
            )
        }
    ) { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {
            BookListComponent(books = state.books)
        }
    }
}

