package com.example.mvi.ui.search

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.mvi.data.BookRepository

class SearchViewModel : ViewModel() {
    private val repository = BookRepository()
    private val _state = mutableStateOf(SearchState())
    val state: State<SearchState> = _state

    fun handleIntent(intent: SearchIntent) {
        when (intent) {
            is SearchIntent.EnterText -> {
                _state.value = _state.value.copy(searchText = intent.text)
            }

            is SearchIntent.SearchClicked -> {
                val results = repository.search(_state.value.searchText)
                _state.value = _state.value.copy(books = results)
            }
        }
    }

    private fun updateState(action: SearchAction) {
        _state.value = SearchReducer.reduce(_state.value, action)
    }
}