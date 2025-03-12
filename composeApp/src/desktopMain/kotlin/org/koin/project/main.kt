package org.koin.project

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import org.koin.project.di.initKoin

fun main() = application {
    initKoin()

    Window(
        onCloseRequest = ::exitApplication,
        title = "Koin",
    ) {
        App()
    }
}