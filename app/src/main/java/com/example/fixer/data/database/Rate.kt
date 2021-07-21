package com.example.fixer.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Rate(
    @PrimaryKey(autoGenerate = true)
    val rateId: Int? = 0,
    val usd: Double? = 0.0,
    val jpy: Double? = 0.0,
    val aud: Double? = 0.0,
    val gbp: Double? = 0.0,
    val cad: Double? = 0.0,
    val chf: Double? = 0.0,
    val cny: Double? = 0.0,
    val sek: Double? = 0.0,
    val nzd: Double? = 0.0
){
    constructor() : this(1,0.0,0.0,0.0,0.0, 0.0, 0.0, 0.0, 0.0, 0.0)
}