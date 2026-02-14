package com.example.mvi.ui.search

import com.example.mvi.domain.Book

data class SearchState(
    val books: List<Book> = emptyList(),
    val searchText: String = "",
)