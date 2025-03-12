package org.koin.project.di

import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import org.koin.core.logger.Logger
import org.koin.dsl.KoinAppDeclaration


class CustomLogger(level: Level = Level.INFO) : Logger(level) {
    override fun display(level: Level, msg: String) {
        // Customize how log messages are displayed
        println("Koin: [${level.name}] $msg")
    }
}

fun initKoin (config: KoinAppDeclaration? = null) {
    startKoin {
        config?.invoke(this)
        modules(sharedModule(), platformModule())
        logger(CustomLogger(Level.INFO))
    }
}