package com.example.mvi.ui.library

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.mvi.data.BookRepository
import androidx.compose.runtime.State

class LibraryViewModel : ViewModel() {
    private val repository = BookRepository()
    private val _state = mutableStateOf(LibraryState())
    val state: State<LibraryState> = _state

    fun handleIntent(intent: LibraryIntent) {
        when (intent) {
            is LibraryIntent.LoadBooks -> {
                val books = repository.getAllBooks()
                _state.value = LibraryReducer.reduce(_state.value, LibraryAction.BooksLoaded(books))
            }
        }
    }
}