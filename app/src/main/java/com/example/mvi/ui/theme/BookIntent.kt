package com.example.mvi.ui.theme

sealed class BookIntent {
    data class EnterText(val text: String) : BookIntent()
    object SearchClicked : BookIntent()
}
