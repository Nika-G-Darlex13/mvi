package com.example.mvi.ui.library

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.mvi.data.BookRepository
import androidx.compose.runtime.State
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class LibraryViewModel : ViewModel() {
    private val repository = BookRepository()
    private val _state = mutableStateOf(LibraryState())
    val state: State<LibraryState> = _state

    init {
             handleIntent(LibraryIntent.LoadBooks)
    }

    fun handleIntent(intent: LibraryIntent) {
        when (intent) {
            is LibraryIntent.LoadBooks -> {
                viewModelScope.launch {
                    val books = repository.getAllBooks()
                    _state.value = _state.value.copy(books = books)
                }
            }
            is LibraryIntent.OnBackClicked ->{

            }
        }
    }
}