package com.example.fixer.repository

import com.example.fixer.domain.Currency
import com.example.fixer.source.LocalDataSource
import com.example.fixer.source.RemoteDataSource

class CurrencyRepository(
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: RemoteDataSource,
    private val BASE_CURRENCY: String = "EUR"
) {

    suspend fun getLatestCurrencies(): List<Currency> {
        if (localDataSource.isEmpty()) {
            val currencies =
                remoteDataSource.getLatestCurrencies(BASE_CURRENCY)
            localDataSource.saveCurrencies(currencies)
        }

        return localDataSource.getLatestCurrencies()
    }
}