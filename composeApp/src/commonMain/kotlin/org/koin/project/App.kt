package org.koin.project

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.KoinContext
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.parameter.parametersOf
import org.koin.java.KoinJavaComponent.inject
import org.koin.project.dependencies.MyViewModel
import org.koin.project.di.Presenter

@Composable
@Preview
fun App() {
    MaterialTheme {
        KoinContext {
            NavHost(
                navController = rememberNavController(),
                startDestination = "home"
            ) {
                composable("home") {
                    Box(modifier = Modifier.fillMaxSize()) {
                        val viewModel = koinViewModel<MyViewModel>()
                        val presenter : Presenter by inject (Presenter::class.java) { parametersOf("Hello World!") }


                        Text(text = viewModel.getHelloWorld() + presenter.string)
                    }
                }
            }
        }
    }
}