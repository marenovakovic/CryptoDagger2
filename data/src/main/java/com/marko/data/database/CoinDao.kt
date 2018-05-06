package com.marko.data.database

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.marko.domain.models.Coin
import io.reactivex.Completable
import io.reactivex.Single

@Dao
interface CoinDao {

	@Insert(onConflict = OnConflictStrategy.REPLACE)
	fun insertCoins(coins: List<Coin>): Completable

	@Query("SELECT * FROM coins")
	fun getAllCoins(): Single<List<Coin>>
}