package com.example.fixer.domain

data class Rate(
    val rateId: Int?,
    var usd: Double?,
    val jpy: Double?,
    val aud: Double?,
    val gbp: Double?,
    val cad: Double?,
    val chf: Double?,
    val cny: Double?,
    val sek: Double?,
    val nzd: Double?
)
