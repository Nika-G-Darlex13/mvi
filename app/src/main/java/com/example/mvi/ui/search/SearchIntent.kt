package com.example.mvi.ui.search

sealed class SearchIntent {
    data class EnterText(val text: String) : SearchIntent()
    object SearchClicked : SearchIntent()
}