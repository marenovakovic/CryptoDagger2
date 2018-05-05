package com.marko.cryptodagger2.view.activities

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.marko.cryptodagger2.R
import com.marko.cryptodagger2.models.Coin
import com.marko.cryptodagger2.view.adapters.CoinAdapter
import com.marko.cryptodagger2.viewmodel.CoinViewModel
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity() {

	private val viewModel: CoinViewModel by lazy {
		ViewModelProviders.of(this).get(CoinViewModel::class.java)
	}

	private val coinsObserver: Observer<List<Coin>> = Observer {
		it?.let {
			(recyclerView.adapter as CoinAdapter).swapCoins(it)
		}
	}

	private val errorObserver: Observer<String> = Observer {
		it?.let {
			toast(it)
		}
	}

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)

		initRecyclerView()

		viewModel.fetch()
		viewModel.getCoinStream().observe(this, coinsObserver)
		viewModel.getErrorStream().observe(this, errorObserver)

		fab.setOnClickListener {
			recyclerView.smoothScrollToPosition(0)
		}
	}

	private fun initRecyclerView() {
		recyclerView.adapter = CoinAdapter()
		recyclerView.layoutManager = LinearLayoutManager(this)

		recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
			override fun onScrollStateChanged(recyclerView: RecyclerView?, newState: Int) {
				if (newState == RecyclerView.SCROLL_STATE_IDLE) {
					fab.show()
				} else {
					fab.hide()
				}
			}
		})
	}
}
