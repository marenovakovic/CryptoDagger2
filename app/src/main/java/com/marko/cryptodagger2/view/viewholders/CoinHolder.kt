package com.marko.cryptodagger2.view.viewholders

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import com.marko.cryptodagger2.R
import com.marko.cryptodagger2.models.Coin

class CoinHolder(view: View): RecyclerView.ViewHolder(view) {
	private val idTextView = view.findViewById<TextView>(R.id.coinId)
	private val nameTextView = view.findViewById<TextView>(R.id.coinName)
	private val symbolTextView = view.findViewById<TextView>(R.id.coinSymbol)

	fun bind(coin: Coin) {
		idTextView.text = coin.id.toString()
		nameTextView.text = coin.name
		symbolTextView.text = coin.symbol
	}
}