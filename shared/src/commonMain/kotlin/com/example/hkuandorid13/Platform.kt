package com.example.hkuandorid13

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform