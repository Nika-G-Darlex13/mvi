package com.example.mvi.ui.theme.BookScreen

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
import com.example.mvi.ui.theme.BookViewModel
import androidx.compose.material3.Button


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LibraryScreen(navController: NavHostController, viewModel: BookViewModel) {
    val uiState by viewModel.state

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
            BookListComponent(books = uiState.books)
        }
    }
}

