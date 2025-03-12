package org.koin.project.di

import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import org.koin.project.dependencies.DbClient

public actual val platformModule = module {
    singleOf(::DbClient)
}