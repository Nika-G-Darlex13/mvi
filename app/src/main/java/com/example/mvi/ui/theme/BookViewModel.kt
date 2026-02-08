package com.example.mvi.ui.theme


import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class BookViewModel : ViewModel() {
    private val repository = BookRepository()
    private val _state = mutableStateOf(BookState())
    val state: State<BookState> = _state

    fun handleIntent(intent: BookIntent) {
        when (intent) {
            is BookIntent.EnterText -> {
                _state.value = _state.value.copy(searchText = intent.text)
            }

            is BookIntent.SearchClicked -> {
                val results = repository.search(_state.value.searchText)
                _state.value = _state.value.copy(books = results)
            }
        }
    }
}
