package com.example.fixer.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Currency::class, Rate::class], version = 1, exportSchema = false)
abstract class CurrencyDatabase : RoomDatabase() {

    companion object {
        fun build(context: Context) = Room.databaseBuilder(
            context,
            CurrencyDatabase::class.java,
            DB_NAME
        ).build()

        private const val DB_NAME = "fixer_api_db"
    }

    abstract fun currencyDao(): CurrencyDAO
    abstract fun rateDao(): RateDAO
}