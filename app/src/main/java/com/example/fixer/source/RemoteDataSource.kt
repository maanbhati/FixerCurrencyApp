package com.example.fixer.source

import com.example.fixer.domain.Currency

interface RemoteDataSource {
    suspend fun getLatestCurrencies(base: String): Currency
}