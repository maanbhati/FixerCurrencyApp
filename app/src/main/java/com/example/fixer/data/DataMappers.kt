package com.example.fixer.data

import com.example.fixer.domain.Currency
import com.example.fixer.data.database.Currency as DomainCurrency
import com.example.fixer.data.server.Currency as ServerCurrency
import com.example.fixer.data.server.Rate as ServerRate
import com.example.fixer.domain.Rate as DomainRate

fun Currency.toRoomCurrency(): DomainCurrency =
    DomainCurrency(
        timestamp,
        getRateData(rates),
        base,
        date
    )

fun DomainCurrency.toDomainCurrency(): Currency =
    Currency(
        timestamp,
        getRateData(this.rates),
        base,
        date
    )

fun ServerCurrency.toDomainCurrency(): Currency =
    Currency(
        timestamp,
        getRateData(this.rates),
        base,
        date
    )

fun DomainRate.toRoomRate(): DomainRate {
    return DomainRate(rateId, usd, jpy, aud, gbp, cad, chf, cny, sek, nzd)
}

fun DomainRate.toDomainRate(): DomainRate {
    return DomainRate(rateId, usd, jpy, aud, gbp, cad, chf, cny, sek, nzd)
}

fun ServerRate.toDomainRate(): DomainRate {
    return DomainRate(rateId, usd, jpy, aud, gbp, cad, chf, cny, sek, nzd)
}

fun getRateData(rate: DomainRate?): DomainRate? {
    rate?.let {
        return DomainRate(
            it.rateId,
            it.usd,
            it.jpy,
            it.aud,
            it.gbp,
            it.cad,
            it.chf,
            it.cny,
            it.sek,
            it.nzd
        )
    }
    return null
}

fun getRateData(rate: ServerRate?): DomainRate? {
    rate?.let {
        return DomainRate(
            it.rateId,
            it.usd,
            it.jpy,
            it.aud,
            it.gbp,
            it.cad,
            it.chf,
            it.cny,
            it.sek,
            it.nzd
        )
    }
    return null
}