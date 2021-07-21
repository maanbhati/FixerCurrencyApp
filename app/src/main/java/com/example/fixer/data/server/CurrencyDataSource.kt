package com.example.fixer.data.server

import com.example.fixer.data.toDomainCurrency
import com.example.fixer.domain.Currency
import com.example.fixer.source.RemoteDataSource

class CurrencyDataSource : RemoteDataSource {
    override suspend fun getLatestCurrencies(base: String): Currency {
        return CurrencyDb.service
            .getAllCurrencies(base, "GBP,USD,JPY,AUD,CAD,CHF,CNY,SEK,NZD").await()
            .toDomainCurrency()
    }
}