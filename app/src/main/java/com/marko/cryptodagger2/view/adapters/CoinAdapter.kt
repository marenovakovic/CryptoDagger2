package com.marko.cryptodagger2.view.adapters

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.marko.cryptodagger2.R
import com.marko.cryptodagger2.extensions.inflate
import com.marko.cryptodagger2.models.Coin
import com.marko.cryptodagger2.view.viewholders.CoinHolder

class CoinAdapter: RecyclerView.Adapter<CoinHolder>() {

	private val coins = ArrayList<Coin>()

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoinHolder {
		val view = parent.inflate(R.layout.list_item_coin)
		return CoinHolder(view)
	}

	override fun onBindViewHolder(holder: CoinHolder, position: Int) {
		val coin = coins[position]
		holder.bind(coin)
	}

	override fun getItemCount(): Int = coins.size

	fun swapCoins(newCoins: List<Coin>) {
		coins.clear()
		coins.addAll(newCoins)
		notifyDataSetChanged()
	}
}