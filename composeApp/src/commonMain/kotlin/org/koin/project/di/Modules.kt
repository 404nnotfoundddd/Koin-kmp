package org.koin.project.di

import org.koin.core.module.Module
import org.koin.core.module.dsl.createdAtStart
import org.koin.core.module.dsl.named
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.core.module.dsl.withOptions
import org.koin.dsl.bind
import org.koin.dsl.module
import org.koin.project.dependencies.MyRepository
import org.koin.project.dependencies.MyRepositoryImpl
import org.koin.project.dependencies.MyViewModel

expect val platformModule: Module

data class Presenter(val string: String)

val sharedModule = module {
    singleOf(::MyRepositoryImpl) bind MyRepository::class withOptions {
        named("MyRepository")
        createdAtStart()
    }

    single { (string: String) -> Presenter(string) }

    viewModelOf(::MyViewModel)
}