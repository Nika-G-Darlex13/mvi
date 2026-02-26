package com.example.mvi.ui.library

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.material3.Button
import com.example.mvi.ui.BookListComponent
import com.example.mvi.ui.theme.Pink40

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LibraryScreen(
    state: LibraryState,
    onAction: (LibraryIntent)-> Unit
){
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Моя библиотека") },
                navigationIcon = {
                    Button(
                        onClick = { onAction(LibraryIntent.OnBackClicked) },
                        colors = ButtonDefaults.buttonColors(containerColor = Pink40)
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


