package com.example.mvi.ui.library

import com.example.mvi.domain.Book

sealed class LibraryAction {
    data class BooksLoaded(val books: List<Book>) : LibraryAction()
}

object LibraryReducer {
    fun reduce(state: LibraryState, action: LibraryAction): LibraryState {
        return when (action) {
            is LibraryAction.BooksLoaded -> state.copy(books = action.books)
        }
    }
}