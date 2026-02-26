package com.example.mvi.ui.library

sealed class LibraryIntent {
    object LoadBooks : LibraryIntent()

    object OnBackClicked : LibraryIntent()
}