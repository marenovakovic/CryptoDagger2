package com.marko.data.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.marko.domain.models.Coin

@Database(entities = [(Coin::class)], version = 1)
abstract class CoinDatabase: RoomDatabase() {

	abstract fun coinDao(): CoinDao
}