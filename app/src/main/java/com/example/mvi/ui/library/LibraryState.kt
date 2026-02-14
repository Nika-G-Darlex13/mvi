package com.example.mvi.ui.library

import com.example.mvi.domain.Book

data class LibraryState(
    val books: List<Book> = emptyList()
)