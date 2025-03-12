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

expect fun platformModule(): Module

data class Presenter(val string: String)

fun sharedModule() = module {
    singleOf(::MyRepositoryImpl) bind MyRepository::class withOptions {
        named("MyRepository")
        // if you need to load some definition at a special time (in a background thread instead of UI for example),
        // just get/inject the desired components.
        // source: https://insert-koin.io/docs/reference/koin-core/definitions#using-definition-flags
        createdAtStart()
    }

    single { (string: String) -> Presenter(string) }

    viewModelOf(::MyViewModel)
}