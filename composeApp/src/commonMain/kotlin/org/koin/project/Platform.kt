package org.koin.project

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform