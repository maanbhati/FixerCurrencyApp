package com.example.fixer.domain

data class Currency(
    val timestamp: Int,
    val rates: Rate?,
    val base: String,
    val date: String
)
