package com.example.fixer.di

import android.app.Application
import androidx.annotation.VisibleForTesting
import com.example.fixer.data.database.CurrencyDatabase
import com.example.fixer.data.database.RoomDataSource
import com.example.fixer.data.server.CurrencyDataSource
import com.example.fixer.repository.CurrencyRepository
import com.example.fixer.source.LocalDataSource
import com.example.fixer.source.RemoteDataSource
import com.example.fixer.ui.main.CurrencyFragment
import com.example.fixer.ui.main.CurrencyViewModel
import com.example.fixer.usecase.GetCurrencies
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.core.qualifier.named
import org.koin.dsl.module

fun Application.initDI() {
    startKoin {
        androidLogger()
        androidContext(this@initDI)
        modules(listOf(appModule, dataModule, scopesModule))
    }
}

@VisibleForTesting
val appModule = module {
    single { CurrencyDatabase.build(get()) }
    factory<LocalDataSource> { RoomDataSource(get()) }
    factory<RemoteDataSource> { CurrencyDataSource() }
    single<CoroutineDispatcher> { Dispatchers.Main }
}

@VisibleForTesting
val dataModule = module {
    factory { CurrencyRepository(get(), get()) }
}

@VisibleForTesting
val scopesModule = module {
    scope(named<CurrencyFragment>()) {
        viewModel { CurrencyViewModel(get(), get()) }
        scoped { GetCurrencies(get()) }
    }
}