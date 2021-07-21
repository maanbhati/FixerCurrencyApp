package com.example.fixer.usecase

import com.example.fixer.domain.Currency
import com.example.fixer.repository.CurrencyRepository

class GetCurrencies(private val currenciesRepository: CurrencyRepository) {
    suspend fun invoke(): List<Currency> = currenciesRepository.getLatestCurrencies()
}