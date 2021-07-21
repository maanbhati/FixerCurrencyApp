package com.example.fixer.data.server

import com.example.fixer.ui.commons.Constants.Companion.API_KEY
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Query

interface CurrencyDbService {
    @GET(API_KEY)
    fun getAllCurrencies(
        @Query("base") base: String,
        @Query("symbols") symbols: String
    ): Deferred<Currency>
}