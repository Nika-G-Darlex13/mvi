package com.example.mvi.data

import com.example.mvi.domain.Book

class BookRepository {
    val dataSource = LibraryDataSource()
    fun getAllBooks(): List<Book> {
        return dataSource.getAllBooks()
    }
     fun search(query: String): List<Book> {
        return dataSource.getAllBooks().filter { it.title.contains(query, ignoreCase = true) }
            .take(5)
    }
}