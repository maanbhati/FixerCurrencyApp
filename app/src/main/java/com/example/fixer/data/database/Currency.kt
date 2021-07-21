package com.example.fixer.data.database

import android.os.Parcelable
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.fixer.domain.Rate
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue

@Parcelize
@Entity
data class Currency(
    @PrimaryKey(autoGenerate = true)
    val timestamp: Int,
    @Embedded val rates: @RawValue Rate?,
    val base: String,
    val date: String
) : Parcelable {
    constructor() : this(1, null, "", "")
}