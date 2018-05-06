package com.marko.cryptodagger2.view.activities

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.marko.cryptodagger2.R
import com.marko.cryptodagger2.extensions.hide
import com.marko.cryptodagger2.extensions.show
import com.marko.domain.models.Coin
import com.marko.cryptodagger2.view.adapters.CoinAdapter
import com.marko.cryptodagger2.view.state.MainActivityState
import com.marko.cryptodagger2.viewmodel.CoinViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

	private val viewModel: CoinViewModel by lazy {
		ViewModelProviders.of(this).get(CoinViewModel::class.java)
	}

	private val coinsObserver: Observer<List<Coin>> = Observer {
		it?.let {
			(recyclerView.adapter as CoinAdapter).swapCoins(it)
		}
	}

	private val stateObserver: Observer<Int> = Observer { it?.let { handleState(it) } }

	private val errorObserver: Observer<String> = Observer { showError(it) }

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)

		initRecyclerView()

		viewModel.fetch()
		viewModel.getCoinStream().observe(this, coinsObserver)
		viewModel.getStateStream().observe(this, stateObserver)
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

	private fun handleState(state: Int) =
			when (state) {
				MainActivityState.LOADING -> {
					progressBar.show()
				}
				MainActivityState.DONE_LOADING -> {
					progressBar.hide()
				}
				MainActivityState.ERROR -> {
					progressBar.hide()
				}
				else -> {
					progressBar.hide()
				}
			}
}
