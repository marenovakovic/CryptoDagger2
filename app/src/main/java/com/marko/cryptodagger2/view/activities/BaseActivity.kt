package com.marko.cryptodagger2.view.activities

import android.support.v7.app.AppCompatActivity
import org.jetbrains.anko.toast

abstract class BaseActivity: AppCompatActivity() {
	protected fun showError(error: String?) =
			error?.let {
				toast(it)
			}
}