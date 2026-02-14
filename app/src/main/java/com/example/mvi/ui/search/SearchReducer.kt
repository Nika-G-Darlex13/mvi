package com.example.mvi.ui.search

import com.example.mvi.domain.Book

sealed class SearchAction {
    data class TextUpdated(val text: String) : SearchAction()
    data class SearchResultsLoaded(val books: List<Book>) : SearchAction()
}

object SearchReducer {
    fun reduce(state: SearchState, action: SearchAction): SearchState {
        return when (action) {
            is SearchAction.TextUpdated ->
                state.copy(searchText = action.text)

            is SearchAction.SearchResultsLoaded ->
                state.copy(books = action.books)
        }
    }
}
