package com.example.fixer.source

import com.example.fixer.domain.Currency

interface LocalDataSource {
    suspend fun isEmpty(): Boolean
    suspend fun saveCurrencies(currencies: Currency)
    suspend fun getLatestCurrencies(): List<Currency>
    suspend fun findById(id: Int): Currency
    suspend fun update(currency: Currency)
}