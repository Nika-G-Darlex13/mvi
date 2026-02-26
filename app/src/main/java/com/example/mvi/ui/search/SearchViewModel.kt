package com.example.mvi.ui.search

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvi.data.BookRepository
import kotlinx.coroutines.launch

class SearchViewModel : ViewModel() {
    private val repository = BookRepository()
    private val _state = mutableStateOf(SearchState())
    val state: State<SearchState> = _state

    fun handleIntent(intent: SearchIntent) {
        when (intent) {
            is SearchIntent.OnSearchFieldInputChanged -> {
                _state.value = _state.value.copy(searchText = intent.text)
            }

            is SearchIntent.OnSearchClicked -> {
                viewModelScope.launch {
                    val results = repository.search(_state.value.searchText)
                    _state.value = _state.value.copy(books = results)
                }
            }
        }
    }
}