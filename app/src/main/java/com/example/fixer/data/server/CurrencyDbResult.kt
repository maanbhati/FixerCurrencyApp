package com.example.fixer.data.server

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Currency(
    val timestamp: Int,
    @SerializedName("rates")
    val rates: Rate?,
    val base: String,
    val date: String
) : Parcelable

@Parcelize
data class Rate(
    val rateId: Int,
    @SerializedName("USD")
    val usd: Double,
    @SerializedName("JPY")
    val jpy: Double,
    @SerializedName("AUD")
    val aud: Double,
    @SerializedName("GBP")
    val gbp: Double,
    @SerializedName("CAD")
    val cad: Double,
    @SerializedName("CHF")
    val chf: Double,
    @SerializedName("CNY")
    val cny: Double,
    @SerializedName("SEK")
    val sek: Double,
    @SerializedName("NZD")
    val nzd: Double
) : Parcelable