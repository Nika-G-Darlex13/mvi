package com.example.mvi.ui.search

sealed class SearchIntent {
    data class OnSearchFieldInputChanged(val text: String) : SearchIntent()

    object OnSearchClicked : SearchIntent()
}