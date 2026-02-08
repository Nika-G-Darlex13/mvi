package com.example.mvi.ui.theme.BookScreen

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.mvi.ui.theme.BookIntent
import com.example.mvi.ui.theme.BookViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen(navController: NavHostController, viewModel: BookViewModel) {
    val uiState by viewModel.state

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Поиск книг") })
        },
        bottomBar = {
            Button(
                onClick = { navController.navigate("library") },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(containerColor = PinkColor)
            ) {
                Text("Библиотека")
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            SearchBarComponent(
                query = uiState.searchText,
                onQueryChange = { viewModel.handleIntent(BookIntent.EnterText(it)) },
                onSearchClick = { viewModel.handleIntent(BookIntent.SearchClicked) }
            )

            BookListComponent(
                books = uiState.books
            )
        }
    }
}


