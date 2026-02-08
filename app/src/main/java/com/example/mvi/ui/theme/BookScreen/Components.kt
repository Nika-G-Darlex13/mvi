package com.example.mvi.ui.theme.BookScreen


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.mvi.ui.theme.Book

val PinkColor = Color(0xFFE91E63)

@Composable
fun SearchBarComponent(
    query: String,
    onQueryChange: (String) -> Unit,
    onSearchClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
    ) {
        TextField(
            value = query,
            onValueChange = onQueryChange,
            modifier = Modifier.fillMaxWidth(),
            label = { Text("Название книги") }
        )
        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = onSearchClick,
            colors = ButtonDefaults.buttonColors(containerColor = PinkColor)
        ) {
            Text("Найти")
        }
    }
}

@Composable
fun BookListComponent(books: List<Book>) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
    ) {
        items(books) { book ->
            BookItemComponent(book)
        }
    }
}

@Composable
fun BookItemComponent(book: Book) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = book.title, style = MaterialTheme.typography.titleMedium)
            Text(text = book.author, style = MaterialTheme.typography.bodySmall)
            Text(
                text = "${book.price} рублей",
                style = MaterialTheme.typography.labelLarge,
                modifier = Modifier.padding(top = 4.dp)
            )
        }
    }
}
