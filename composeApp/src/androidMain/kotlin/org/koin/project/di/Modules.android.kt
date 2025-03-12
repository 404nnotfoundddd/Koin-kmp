package org.koin.project.di

import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import org.koin.project.dependencies.DbClient

actual val platformModule = module {
    singleOf(::DbClient)
}